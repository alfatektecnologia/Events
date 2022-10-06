package br.com.oliveira.emanoel.events.network.api

import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.domain.model.EventCheckIn
import br.com.oliveira.emanoel.events.network.response.EventsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsApi {

    @GET("events")
    suspend fun getEvents(): EventsResponse

    @GET("events/{id}")
    suspend fun getEventById(@Path("id") id: Long): Event

    @POST("checkin")
    suspend fun postCheckIn(@Body eventCheckIn: EventCheckIn): Any

}
