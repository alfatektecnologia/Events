package br.com.oliveira.emanoel.events.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventCheckIn(
    val eventId: String?,
    val name: String,
    val email: String
): Parcelable
