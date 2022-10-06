package br.com.oliveira.emanoel.events.network.model


import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.network.response.EventsResponse
import br.com.oliveira.emanoel.events.domain.util.DomainMapper
import dagger.Provides
import javax.inject.Inject

class EventsDtoMapper @Inject constructor(): DomainMapper<EventDto, Event> {
    override fun mapToDomainModel(model: EventDto): Event {
        return Event(
            people = model.people,
            date = model.date,
            description = model.description,
            image = model.image,
            longitude = model.longitude,
            latitude = model.latitude,
            price = model.price,
            title = model.title,
            id = model.id
        )
    }

    override fun mapFromDomainModel(domainModel: Event): EventDto {
       return EventDto(
           people = domainModel.people,
           date = domainModel.date,
           description = domainModel.description,
           image = domainModel.image,
           longitude = domainModel.longitude,
           latitude = domainModel.latitude,
           price = domainModel.price,
           title = domainModel.title,
           id = domainModel.id
       )
    }

    fun fromDomainResponse (initial: EventsResponseDto): EventsResponse {
        return EventsResponse()
    }

    fun fromDomainList(initial: ArrayList<EventDto>): List<Event>{
        return initial.map { mapToDomainModel(it) }
    }
}