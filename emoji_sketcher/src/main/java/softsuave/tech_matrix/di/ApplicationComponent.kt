package softsuave.tech_matrix.di
import dagger.Component
import softsuave.tech_matrix.di.drawEmoji.DrawEmojiComponent
import javax.inject.Singleton
@Singleton
@Component(modules = [(ApplicationModule::class), (ServiceModule::class)])
internal interface ApplicationComponent {

    fun plusDrawEmojiComponent(): DrawEmojiComponent

}
