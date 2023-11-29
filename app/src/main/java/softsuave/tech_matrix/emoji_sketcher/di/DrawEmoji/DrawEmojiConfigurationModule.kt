package softsuave.tech_matrix.emoji_sketcher.di.DrawEmoji

import dagger.Module
import dagger.Provides
import softsuave.tech_matrix.emoji_sketcher.di.ActivityScope

@Module
object DrawEmojiConfigurationModule {

    @Provides
    @JvmStatic
    @ActivityScope
    fun providePracticeSize(): Int {
        return 10
    }
}