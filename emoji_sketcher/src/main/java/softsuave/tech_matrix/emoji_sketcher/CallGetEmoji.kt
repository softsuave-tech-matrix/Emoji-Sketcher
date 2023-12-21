package softsuave.tech_matrix.emoji_sketcher

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import softsuave.tech_matrix.emoji_sketcher.ui.DrawEmojiActivity
import softsuave.tech_matrix.emoji_sketcher.util.GetEmojiItemClickListener

class CallGetEmoji(private val activity: AppCompatActivity) {
    private lateinit var listener: GetEmojiItemClickListener

    fun setListener(listener: GetEmojiItemClickListener) {
        this.listener = listener
    }

    fun startActivityForEmoji(launcher: ActivityResultLauncher<Intent>) {
        val intent = Intent(activity, DrawEmojiActivity::class.java)
        launcher.launch(intent)
    }

    fun handleActivityResult(selectedEmoji: String) {
        listener.getEmojiItemClick(selectedEmoji)
    }
}