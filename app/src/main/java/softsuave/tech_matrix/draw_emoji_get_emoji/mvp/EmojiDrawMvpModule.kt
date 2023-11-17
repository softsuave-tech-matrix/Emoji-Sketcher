package softsuave.tech_matrix.draw_emoji_get_emoji.mvp

import dagger.Binds
import dagger.Module
import dagger.Provides
import softsuave.tech_matrix.draw_emoji_get_emoji.data.EmojiToDrawProvider
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ActivityScope
import softsuave.tech_matrix.draw_emoji_get_emoji.ui.EmojiDrawContract
import softsuave.tech_matrix.draw_emoji_get_emoji.ui.EmojiDrawPresenter
import softsuave.tech_matrix.draw_emoji_get_emoji.util.FixedEmojiToDrawProvider

@Module
abstract class EmojiDrawMvpModule {

    @Binds
    @ActivityScope
    abstract fun provideEmojiDrawPresenter(presenter: EmojiDrawPresenter): EmojiDrawContract.Presenter

    @Module
    companion object {

        @Provides
        @ActivityScope
        @JvmStatic
        fun provideVersionBasedEmojiToDrawProvider(): EmojiToDrawProvider {
            return FixedEmojiToDrawProvider()
        }
    }
}
