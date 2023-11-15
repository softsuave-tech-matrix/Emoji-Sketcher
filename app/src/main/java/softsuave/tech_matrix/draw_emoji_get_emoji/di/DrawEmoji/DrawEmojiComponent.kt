package softsuave.tech_matrix.draw_emoji_get_emoji.di.DrawEmoji


import dagger.Subcomponent
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ActivityScope
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ApplicationModule
import softsuave.tech_matrix.draw_emoji_get_emoji.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [(ApplicationModule::class), (DrawEmojiConfigurationModule::class)])
interface DrawEmojiComponent {

    fun inject(mainActivity: MainActivity)
}
