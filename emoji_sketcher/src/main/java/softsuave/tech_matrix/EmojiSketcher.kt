package softsuave.tech_matrix

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.disposables.CompositeDisposable
import com.softsuave.emoji_sketcher.databinding.DrawEmojiActivityBinding
import softsuave.tech_matrix.adapter.EmojiDetectedAdapter
import softsuave.tech_matrix.example.EmojiDrawContract
import softsuave.tech_matrix.utils.GetEmojiItemClickListener
import timber.log.Timber
import javax.inject.Inject


  class EmojiSketcher(private val context: Context,private val getSelectedEmoji : GetSelectedEmoji?=null  ) : Fragment(), EmojiDrawContract.View,
      GetEmojiItemClickListener {

    @Inject
    lateinit var presenter: EmojiDrawContract.Presenter
        private lateinit var alertDialog:AlertDialog
    private lateinit var adapter: EmojiDetectedAdapter
    private lateinit var binding: DrawEmojiActivityBinding

    private val disposables = CompositeDisposable()
    fun show(): EmojiSketcher {
        MyApplication.getComponent(context)
            .plusDrawEmojiComponent()
            .inject(this)

        binding = DrawEmojiActivityBinding.inflate(LayoutInflater.from(context))
        val view = binding.root
        binding.emojiDetectedRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = EmojiDetectedAdapter(context)
        binding.emojiDetectedRecycler.adapter = adapter

        presenter.bindView(this)
        binding.drawingView.strokesObservable
            ?.subscribe { presenter.onStrokeAdded(it) }?.let { disposables.add(it) }
        disposables.add(binding.drawingView.skipObservable
            .subscribe { presenter.onSkip() })
        adapter.setOnItemClickListener(this)

          alertDialog = AlertDialog.Builder(context).create().apply {
            setView(view)
        }
        alertDialog.show()
        return this
    }


    override fun onGuessesReturned(strings: List<String>) {
        binding.emojiDetectedContainer.visibility = View.VISIBLE
        adapter.detectedList = strings
    }

    override fun setEmojiToDraw(emoji: String, emojiDescription: String) {
        adapter.emojiToDraw = emoji
    }

    override fun onEmojiDrawnCorrectly(emoji: String) {
        binding.emojiDetectedContainer.visibility = View.INVISIBLE
        adapter.detectedList = emptyList()
        binding.drawingView.clear()
    }

    override fun onAllEmojisDrawn() {
        Timber.d("onAllEmojisDrawn")
    }

    override fun onAllEmojisDrawnWithCheat() {
        Timber.d("onAllEmojisDrawnWithCheat")
    }

    override fun onTimeOut() {
        Timber.d("OnTimeout")
    }

    override fun showErrorMessage() {
        Timber.d("\uD83D\uDE1E Check your internet connection \uD83D\uDCF6")
    }


    override fun getEmojiItemClick(emoji: String) {
        Timber.d("Emoji String ====> %s", emoji)
        getSelectedEmoji?.getSelectedEmoji(emoji)
        alertDialog.dismiss()
    }
}