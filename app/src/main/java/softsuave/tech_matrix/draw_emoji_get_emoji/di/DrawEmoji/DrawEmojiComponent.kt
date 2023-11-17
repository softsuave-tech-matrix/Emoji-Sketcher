package softsuave.tech_matrix.draw_emoji_get_emoji.di.DrawEmoji

import dagger.Subcomponent
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ActivityScope
import softsuave.tech_matrix.draw_emoji_get_emoji.mvp.EmojiDrawMvpModule
import softsuave.tech_matrix.draw_emoji_get_emoji.ui.DrawEmojiActivity

@ActivityScope
@Subcomponent(modules = [(EmojiDrawMvpModule::class), (DrawEmojiConfigurationModule::class)])
interface DrawEmojiComponent {

    fun inject(mainActivity: DrawEmojiActivity)
}
