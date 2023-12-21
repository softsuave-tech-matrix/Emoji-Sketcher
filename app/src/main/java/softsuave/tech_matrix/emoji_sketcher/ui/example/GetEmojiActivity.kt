package softsuave.tech_matrix.emoji_sketcher.ui.example

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import softsuave.tech_matrix.emoji_sketcher.CallGetEmoji
import softsuave.tech_matrix.emoji_sketcher.databinding.GetEmojiActivityBinding
import softsuave.tech_matrix.emoji_sketcher.util.GetEmojiItemClickListener
import timber.log.Timber

class GetEmojiActivity : AppCompatActivity(), GetEmojiItemClickListener {
    private var _binding: GetEmojiActivityBinding? = null
    private val binding by lazy { _binding!! }
    private val REQUEST_EMOJI_ICON_CODE = 1234
    private lateinit var callGetEmoji: CallGetEmoji

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == REQUEST_EMOJI_ICON_CODE) {
            val data: Intent? = result.data
            val selectedEmoji = data?.getStringExtra("selectedEmoji")
            selectedEmoji?.let {
                callGetEmoji.handleActivityResult(it)
                binding.emojiIcon.text = it
            }
        }
    }
    val Context.isInternetAvailable: Boolean
        get() {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = connectivityManager.activeNetwork ?: return false
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
            return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = GetEmojiActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callGetEmoji = CallGetEmoji(this)
        callGetEmoji.setListener(this)
        binding.getEmojiButton.setOnClickListener {
            if (isInternetAvailable) {
                callGetEmoji.startActivityForEmoji(launcher)
            } else {
                Toast.makeText(this, "Please check your internet connection.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        launcher.unregister()
    }

    override fun getEmojiItemClick(emoji: String) {
        Timber.tag("ClickedItemFromLibrary").d(emoji);
    }

}