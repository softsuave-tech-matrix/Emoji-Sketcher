package softsuave.tech_matrix.draw_emoji_get_emoji.di

import dagger.Component
import softsuave.tech_matrix.draw_emoji_get_emoji.di.DrawEmoji.DrawEmojiComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (ServiceModule::class)])
interface ApplicationComponent {

    fun plusDrawEmojiComponent(): DrawEmojiComponent

}
