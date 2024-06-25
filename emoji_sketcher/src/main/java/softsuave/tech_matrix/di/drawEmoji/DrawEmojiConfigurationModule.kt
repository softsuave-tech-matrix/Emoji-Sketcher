package softsuave.tech_matrix.di.drawEmoji

import dagger.Module
import dagger.Provides
import softsuave.tech_matrix.di.ActivityScope

@Module
internal object DrawEmojiConfigurationModule {

    @Provides
    @JvmStatic
    @ActivityScope
    fun providePracticeSize(): Int {
        return 10
    }
}