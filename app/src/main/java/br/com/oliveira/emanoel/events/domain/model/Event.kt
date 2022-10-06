package br.com.oliveira.emanoel.events.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(

    val people: ArrayList<EventCheckIn> = arrayListOf(),
    val date: Long? = null,
    val description: String? = null,
    val image: String? = null,
    val longitude: Double? = null,
    val latitude: Double? = null,
    val price: Double? = null,
    val title: String? = null,
    val id: String? = null
):Parcelable
