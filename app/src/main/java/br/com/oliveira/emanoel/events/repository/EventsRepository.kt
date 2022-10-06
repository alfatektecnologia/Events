package br.com.oliveira.emanoel.events.repository

import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.domain.model.EventCheckIn

interface EventsRepository {

        suspend fun getEvents(): List<Event>
        suspend fun getEventsById(id: Int): Event
        suspend fun postCheckIn(eventCheckIn: EventCheckIn): Any
}