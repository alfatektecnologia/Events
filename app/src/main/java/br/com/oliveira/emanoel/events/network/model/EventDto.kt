package br.com.oliveira.emanoel.events.network.model

import br.com.oliveira.emanoel.events.domain.model.EventCheckIn
import com.google.gson.annotations.SerializedName

data class EventDto(

    @SerializedName("people")
    val people: ArrayList<EventCheckIn> = arrayListOf(),
    @SerializedName("date")
    val date: Long? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("longitude")
    val longitude: Double? = null,
    @SerializedName("latitude")
    val latitude: Double? = null,
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("id")
    val id: String? = null

)
