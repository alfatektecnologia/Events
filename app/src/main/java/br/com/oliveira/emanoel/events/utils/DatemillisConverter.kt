package br.com.oliveira.emanoel.events.utils

import java.text.SimpleDateFormat
import java.util.*

    fun DateMillisConverter(date: Long): String {
        val formattedDate = SimpleDateFormat("dd/MM/yy 'as' HH:mm ", Locale.getDefault()).format(date)

        return formattedDate
    }
