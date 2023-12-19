package softsuave.tech_matrix.emoji_sketcher.ui.example

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import softsuave.tech_matrix.emoji_sketcher.ui.DrawEmojiActivity
import timber.log.Timber

class GetEmojiFragment : Fragment() {

    private val REQUEST_EMOJI_ICON_CODE = 1234
    private val drawEmojiLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == REQUEST_EMOJI_ICON_CODE) {
                val data: Intent? = result.data
                val selectedEmoji = data?.getStringExtra("selectedEmoji")
                Timber.d(selectedEmoji)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Call DrawEmojiActivity from your fragment
        val intent = Intent(requireContext(), DrawEmojiActivity::class.java)
        drawEmojiLauncher.launch(intent)
    }

}
