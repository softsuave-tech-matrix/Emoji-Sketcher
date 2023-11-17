package app.we.go.emojidraw.features.practice

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmojiDetectedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private val emojiView: TextView = itemView as TextView
    private val pulseAnimation: ObjectAnimator
    private var itemClickListener: OnItemClickListener? = null

    init {
        pulseAnimation = ObjectAnimator.ofPropertyValuesHolder(
            emojiView,
            PropertyValuesHolder.ofFloat("scaleX", 1.2f),
            PropertyValuesHolder.ofFloat("scaleY", 1.2f)
        )
        pulseAnimation.duration = 310

        pulseAnimation.repeatCount = ObjectAnimator.INFINITE
        pulseAnimation.repeatMode = ObjectAnimator.REVERSE
    }


    fun bind(emoji: String, isTheOne: Boolean) {
        emojiView.text = emoji

        if (isTheOne) {
            pulseAnimation.start()
        } else {
            pulseAnimation.cancel()
        }
    }

    override fun onClick(p0: View?) {
        itemClickListener?.onItemClick(emojiView.text.toString())
    }

}
