package br.com.oliveira.emanoel.events.di

import android.content.Context
import br.com.oliveira.emanoel.events.network.api.EventsApi
import br.com.oliveira.emanoel.events.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideEventsApi(): EventsApi {
        return Retrofit.Builder()
       .baseUrl("https://5f5a8f24d44d640016169133.mockapi.io/api/")
       .addConverterFactory(GsonConverterFactory.create())
       .build()
       .create(EventsApi::class.java)
    }


}