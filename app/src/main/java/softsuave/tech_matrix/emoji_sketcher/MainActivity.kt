package softsuave.tech_matrix.emoji_sketcher

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import softsuave.tech_matrix.EmojiSketcher
import softsuave.tech_matrix.GetSelectedEmoji
import softsuave.tech_matrix.builder.EmojiSketcherBuilder
import softsuave.tech_matrix.emoji_sketcher_app.databinding.MainActivityLayoutBinding


class MainActivity : AppCompatActivity(), GetSelectedEmoji {
    private var _binding: MainActivityLayoutBinding? = null
    private val binding by lazy { _binding!! }

        private var emojiSketcher: EmojiSketcher? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        binding.getEmojiButton.setOnClickListener {
            //building
            emojiSketcher = EmojiSketcherBuilder(this, this).build()
            //show the dialog
            emojiSketcher?.show()
        }
    }

    override fun getSelectedEmoji(emoji: String) {
        binding.emojiIcon.visibility = View.VISIBLE
        binding.emojiIcon.text = emoji
    }
}