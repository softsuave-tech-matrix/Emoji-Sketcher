package softsuave.tech_matrix.example

import softsuave.tech_matrix.di.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import softsuave.tech_matrix.api.EmojiDetectionProvider
import softsuave.tech_matrix.data.EmojiToDraw
import softsuave.tech_matrix.data.EmojiToDrawProvider
import softsuave.tech_matrix.model.Stroke
import softsuave.tech_matrix.mvp.BasePresenter
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
internal open class EmojiDrawPresenter @Inject
constructor(
    private val detectionProvider: EmojiDetectionProvider,
    private val emojiToDrawProvider: EmojiToDrawProvider,
    private val nEmojis: Int
) : BasePresenter<EmojiDrawContract.View>(), EmojiDrawContract.Presenter {

    private var emojisToDraw: List<EmojiToDraw> = emptyList()
    private var currentEmojiIndex: Int = 0
    private var hasSkipped: Boolean = false
    private var won: Boolean = false


    override fun initialize() {
        super.initialize()
        emojisToDraw = emojiToDrawProvider.provide(nEmojis)
        updateEmojiToDraw()
    }

    private fun updateEmojiToDraw() {
        val (description, emoji) = emojisToDraw[currentEmojiIndex]
        view?.setEmojiToDraw(emoji, description)
    }

    override fun onStrokeAdded(strokes: List<Stroke>) {
        disposables.add(
            detectionProvider.getEmojis(strokes)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ processEmojiGuesses(it) },
                    { onError(it) })
        )
    }

    private fun processEmojiGuesses(emojis: List<String>) {
        view?.onGuessesReturned(emojis)
        if (emojis.isNotEmpty() && currentEmojiIndex < emojisToDraw.size) {

            val currentEmoji = emojisToDraw[currentEmojiIndex].emoji

            if (emojis[0] == currentEmoji) {
                disposables.clear()
                view?.onEmojiDrawnCorrectly(currentEmoji)
                handleNextEmoji()
            }
        }
    }

    private fun onError(throwable: Throwable) {
        try {
            Timber.e(throwable)
            view?.showErrorMessage()
        } catch (e: Exception) {
            println(e)
        }
    }

    open fun handleNextEmoji(): Boolean {
        currentEmojiIndex++

        return if (currentEmojiIndex == emojisToDraw.size) {
            won = true
            if (hasSkipped) {
                view?.onAllEmojisDrawnWithCheat()
            } else
                view?.onAllEmojisDrawn()
            false
        } else {
            updateEmojiToDraw()
            true
        }
    }

    override fun onTimeExpired() {
        if (!won) {
            view?.onTimeOut()
        }
    }

    override fun onSkip() {
        if (currentEmojiIndex < emojisToDraw.size) {
            hasSkipped = true
            handleNextEmoji()
        }
    }
}
