package softsuave.tech_matrix.emoji_sketcher.mvp

import dagger.Binds
import dagger.Module
import dagger.Provides
import softsuave.tech_matrix.emoji_sketcher.data.EmojiToDrawProvider
import softsuave.tech_matrix.emoji_sketcher.di.ActivityScope
import softsuave.tech_matrix.emoji_sketcher.ui.EmojiDrawContract
import softsuave.tech_matrix.emoji_sketcher.ui.EmojiDrawPresenter
import softsuave.tech_matrix.emoji_sketcher.util.FixedEmojiToDrawProvider

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
