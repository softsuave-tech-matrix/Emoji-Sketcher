package softsuave.tech_matrix.data

interface EmojiToDrawProvider {

    fun provide(n: Int): List<EmojiToDraw>

}