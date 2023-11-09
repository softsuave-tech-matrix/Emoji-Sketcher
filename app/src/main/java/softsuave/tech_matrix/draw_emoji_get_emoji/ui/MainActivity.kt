package softsuave.tech_matrix.draw_emoji_get_emoji.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import softsuave.tech_matrix.draw_emoji_get_emoji.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private var _binding: MainActivityBinding? = null
    private val binding by lazy { _binding!! }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
