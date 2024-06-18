package softsuave.tech_matrix.example

import softsuave.tech_matrix.model.Stroke
import softsuave.tech_matrix.mvp.MVP

interface EmojiDrawContract {
    interface View : MVP.View {

        fun onGuessesReturned(strings: List<String>)

        fun setEmojiToDraw(emoji: String, emojiDescription: String)

        fun onEmojiDrawnCorrectly(emoji: String)

        fun onAllEmojisDrawn()

        fun onAllEmojisDrawnWithCheat()

        fun onTimeOut()

        fun showErrorMessage()
    }

    interface Presenter : MVP.Presenter<View> {

        fun onStrokeAdded(strokes: List<Stroke>)

        fun onTimeExpired()

        fun onSkip()

    }
}