package softsuave.tech_matrix.emoji_sketcher.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    @CanvasSize
    fun provideCanvasSize(): Int {
        return 260
    }

}