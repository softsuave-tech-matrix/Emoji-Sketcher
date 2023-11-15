package softsuave.tech_matrix.draw_emoji_get_emoji

import android.app.Application
import android.content.Context
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ApplicationComponent
import softsuave.tech_matrix.draw_emoji_get_emoji.di.ApplicationModule
import softsuave.tech_matrix.draw_emoji_get_emoji.di.DaggerApplicationComponent


open class MyApplication: Application() {


    private lateinit var component: ApplicationComponent

    companion object {
        fun getComponent(context: Context): ApplicationComponent {
            return (context.applicationContext as MyApplication).component
        }
    }

    override fun onCreate() {
        super.onCreate()
        component = createComponent()
    }

    protected open fun createComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}