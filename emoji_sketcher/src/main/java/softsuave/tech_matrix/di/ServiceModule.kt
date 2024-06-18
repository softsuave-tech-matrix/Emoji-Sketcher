package softsuave.tech_matrix.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import softsuave.tech_matrix.api.BASE_URL
import softsuave.tech_matrix.api.EmojiDetectionService

import javax.inject.Singleton
@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (true) {
            loggingInterceptor.apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideEmojiDetectionService(retrofit: Retrofit): EmojiDetectionService {
        return retrofit.create(EmojiDetectionService::class.java)
    }

}

