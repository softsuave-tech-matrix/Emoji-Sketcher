package softsuave.tech_matrix.emoji_sketcher.model

data class Emoji(
    val id: Int,
    val categoryId: Int,
    val emoji: String,
    val sinceVersion: Int,
    val description: String
)