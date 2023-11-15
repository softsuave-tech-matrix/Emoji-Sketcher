package softsuave.tech_matrix.draw_emoji_get_emoji.data

import softsuave.tech_matrix.draw_emoji_get_emoji.model.Emoji
import java.util.*

private const val MAX_TRIES = 1000

class RandomEmojiToDrawProvider(private val emojiList: List<Emoji>,
                                private val sdkVersion: Int): EmojiToDrawProvider {
    private val random: Random = Random()

    override fun provide(n: Int): List<EmojiToDraw> {

        return (1..MAX_TRIES).asSequence().map {
            emojiList[random.nextInt(emojiList.size)]
        }
                .filter {
                    it.sinceVersion <= sdkVersion
                }
                .distinct()
                .take(n)
                .map {
                    EmojiToDraw(it.description, it.emoji)
                }.toList()
    }
}