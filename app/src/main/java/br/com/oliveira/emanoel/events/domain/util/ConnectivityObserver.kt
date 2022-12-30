package br.com.oliveira.emanoel.events.domain.util

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observe(): Flow<Status>

    enum class Status {Disponivel, Indisponivel }
}