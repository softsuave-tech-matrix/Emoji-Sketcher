package app.we.go.emojidraw.features.practice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import softsuave.tech_matrix.draw_emoji_get_emoji.R
import softsuave.tech_matrix.draw_emoji_get_emoji.ui.adapter.EmojiDiffCallback

class EmojiDetectedAdapter(val context: Context) : RecyclerView.Adapter<EmojiDetectedViewHolder>() {

    lateinit var emojiToDraw: String
    private var itemClickListener: OnItemClickListener? = null

    var detectedList: List<String> = emptyList()
        set(list) {
            val diffResult = DiffUtil.calculateDiff(EmojiDiffCallback(list, detectedList))
            diffResult.dispatchUpdatesTo(this)
            field = list
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiDetectedViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.emoji_detected_item, parent, false)
        return EmojiDetectedViewHolder(itemView)
    }

    override fun getItemCount() = detectedList.size

    override fun onBindViewHolder(holder: EmojiDetectedViewHolder, position: Int) {
        val detectedEmoji = detectedList[position]
        holder.bind(detectedEmoji, detectedEmoji == emojiToDraw)
        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(detectedEmoji)
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }
}

interface OnItemClickListener {
    fun onItemClick(emoji: String)
}
