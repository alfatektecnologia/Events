package br.com.oliveira.emanoel.events.repository

import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.domain.model.EventCheckIn
import br.com.oliveira.emanoel.events.network.api.EventsApi
import br.com.oliveira.emanoel.events.network.model.EventsDtoMapper

class EventsRepositoryImpl(private val eventsApi: EventsApi, private val mapper:EventsDtoMapper): EventsRepository {

    override suspend fun getEvents(): List<Event> {
       return  mapper.fromDomainList(eventsApi.getEvents())
    }

    override suspend fun getEventsById(id: Int): Event {
        TODO("Not yet implemented")
    }

    override suspend fun postCheckIn(eventCheckIn: EventCheckIn): Any {
        return eventsApi.postCheckIn(eventCheckIn)
    }
}