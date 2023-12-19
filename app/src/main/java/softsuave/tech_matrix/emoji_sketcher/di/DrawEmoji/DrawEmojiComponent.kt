package softsuave.tech_matrix.emoji_sketcher.di.DrawEmoji

import dagger.Subcomponent
import softsuave.tech_matrix.emoji_sketcher.di.ActivityScope
import softsuave.tech_matrix.emoji_sketcher.mvp.EmojiDrawMvpModule
import softsuave.tech_matrix.emoji_sketcher.ui.DrawEmojiActivity

@ActivityScope
@Subcomponent(modules = [(EmojiDrawMvpModule::class), (DrawEmojiConfigurationModule::class)])
interface DrawEmojiComponent {

    fun inject(drawEmojiActivity: DrawEmojiActivity)
}
