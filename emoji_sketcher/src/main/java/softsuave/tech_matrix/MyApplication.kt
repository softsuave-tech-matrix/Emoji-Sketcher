package softsuave.tech_matrix

import android.app.Application
import android.content.Context
import softsuave.tech_matrix.di.ApplicationComponent
import softsuave.tech_matrix.di.ApplicationModule
import softsuave.tech_matrix.di.DaggerApplicationComponent


internal class MyApplication: Application() {

    private lateinit var component: ApplicationComponent

    companion object {
        fun getComponent(context: Context): ApplicationComponent {
            return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(context))
                .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        component = createComponent()
    }

     fun createComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}