package softsuave.tech_matrix.draw_emoji_get_emoji.di.DrawEmoji

import dagger.Module
import dagger.Provides
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ActivityScope

@Module
object DrawEmojiConfigurationModule {

    @Provides
    @JvmStatic
    @ActivityScope
    fun providePracticeSize(): Int {
        return 10
    }
}