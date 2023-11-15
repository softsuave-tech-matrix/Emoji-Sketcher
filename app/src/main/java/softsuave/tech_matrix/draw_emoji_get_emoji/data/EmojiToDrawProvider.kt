package softsuave.tech_matrix.draw_emoji_get_emoji.data

interface EmojiToDrawProvider {

    fun provide(n: Int) : List<EmojiToDraw>

}