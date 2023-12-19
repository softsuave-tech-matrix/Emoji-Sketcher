package softsuave.tech_matrix.emoji_sketcher.di

import dagger.Component
import softsuave.tech_matrix.emoji_sketcher.di.DrawEmoji.DrawEmojiComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (ServiceModule::class)])
interface ApplicationComponent {

    fun plusDrawEmojiComponent(): DrawEmojiComponent

}
