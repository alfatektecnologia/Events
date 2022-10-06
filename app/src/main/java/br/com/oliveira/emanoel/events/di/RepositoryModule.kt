package br.com.oliveira.emanoel.events.di

import br.com.oliveira.emanoel.events.network.api.EventsApi
import br.com.oliveira.emanoel.events.network.model.EventsDtoMapper
import br.com.oliveira.emanoel.events.repository.EventsRepository
import br.com.oliveira.emanoel.events.repository.EventsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideEventsRepository(
        eventsApi: EventsApi,
        eventsDtoMapper: EventsDtoMapper
    ): EventsRepository{
        return EventsRepositoryImpl(eventsApi,eventsDtoMapper)

    }
}