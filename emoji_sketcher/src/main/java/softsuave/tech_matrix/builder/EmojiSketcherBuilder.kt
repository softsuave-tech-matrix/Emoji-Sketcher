package softsuave.tech_matrix.builder

import android.content.Context
import softsuave.tech_matrix.EmojiSketcher
import softsuave.tech_matrix.GetSelectedEmoji

class EmojiSketcherBuilder(private val context: Context, private val getSelectedEmoji: GetSelectedEmoji) {

    fun build() =
        run {

            EmojiSketcher(context,getSelectedEmoji)
        }

}