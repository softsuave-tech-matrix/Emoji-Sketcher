package softsuave.tech_matrix.di.drawEmoji

import dagger.Subcomponent
import softsuave.tech_matrix.EmojiSketcher
import softsuave.tech_matrix.di.ActivityScope
import softsuave.tech_matrix.mvp.EmojiDrawMvpModule

@ActivityScope
@Subcomponent(modules = [(EmojiDrawMvpModule::class), (DrawEmojiConfigurationModule::class)])
interface DrawEmojiComponent {

    fun inject(emojiSketcher: EmojiSketcher)
}