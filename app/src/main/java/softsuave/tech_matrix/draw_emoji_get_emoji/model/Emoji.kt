package softsuave.tech_matrix.draw_emoji_get_emoji.model

data class Emoji(val id: Int,
                 val categoryId: Int,
                 val emoji: String,
                 val sinceVersion: Int,
                 val description: String)