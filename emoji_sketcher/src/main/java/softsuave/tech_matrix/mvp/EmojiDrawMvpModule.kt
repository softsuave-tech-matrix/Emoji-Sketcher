package softsuave.tech_matrix.mvp
import dagger.Binds
import dagger.Module
import dagger.Provides
import softsuave.tech_matrix.data.EmojiToDrawProvider
import softsuave.tech_matrix.di.ActivityScope
import softsuave.tech_matrix.example.EmojiDrawContract
import softsuave.tech_matrix.example.EmojiDrawPresenter
import softsuave.tech_matrix.utils.FixedEmojiToDrawProvider

@Module
internal abstract class EmojiDrawMvpModule {

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
