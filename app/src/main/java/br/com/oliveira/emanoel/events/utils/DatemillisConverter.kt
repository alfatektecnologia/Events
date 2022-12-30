package br.com.oliveira.emanoel.events.utils

import java.text.SimpleDateFormat
import java.util.*

    fun DateMillisConverter(date: Long): String {
        var formattedDate = ""
        formattedDate = try {
            SimpleDateFormat("dd/MM/yy 'as' HH:mm ", Locale.getDefault()).format(date)
        } catch (e: Exception) {
            "Data inválida"
        }
       return formattedDate
    }
