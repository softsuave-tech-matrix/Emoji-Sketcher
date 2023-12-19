package softsuave.tech_matrix.emoji_sketcher

import android.app.Application
import android.content.Context
import softsuave.tech_matrix.emoji_sketcher.di.ApplicationComponent
import softsuave.tech_matrix.emoji_sketcher.di.ApplicationModule
import softsuave.tech_matrix.emoji_sketcher.di.DaggerApplicationComponent

open class MyApplication : Application() {

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