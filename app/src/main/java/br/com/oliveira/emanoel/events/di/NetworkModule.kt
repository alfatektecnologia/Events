package br.com.oliveira.emanoel.events.di

import br.com.oliveira.emanoel.events.network.model.EventsDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideEventsMapper(): EventsDtoMapper{
        return EventsDtoMapper()
    }

}