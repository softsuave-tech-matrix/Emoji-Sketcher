package softsuave.tech_matrix.emoji_sketcher.ui.example

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import softsuave.tech_matrix.emoji_sketcher.databinding.GetEmojiActivityBinding
import softsuave.tech_matrix.emoji_sketcher.ui.DrawEmojiActivity

class GetEmojiActivity : AppCompatActivity() {
    private var _binding: GetEmojiActivityBinding? = null
    private val binding by lazy { _binding!! }
    private val REQUEST_EMOJI_ICON_CODE = 1234
    private val drawEmojiLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == REQUEST_EMOJI_ICON_CODE) {
                val data: Intent? = result.data
                val selectedEmoji = data?.getStringExtra("selectedEmoji")
                binding.emojiIcon.text = selectedEmoji
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
        binding.getEmojiButton.setOnClickListener {
            if (isInternetAvailable) {
                //From Activity
                val intent = Intent(this, DrawEmojiActivity::class.java)
                drawEmojiLauncher.launch(intent)

                //Call From Fragment
                /*            val fragment = GetEmojiFragment()
                            val bundle = Bundle()
                            fragment.arguments = bundle

                            // Add the fragment to the activity
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit()*/
            } else {
                Toast.makeText(this, "Please check your internet connection.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}