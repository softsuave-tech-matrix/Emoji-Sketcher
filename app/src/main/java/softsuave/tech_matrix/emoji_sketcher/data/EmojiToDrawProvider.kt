package softsuave.tech_matrix.emoji_sketcher.data

interface EmojiToDrawProvider {

    fun provide(n: Int): List<EmojiToDraw>

}