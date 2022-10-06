package br.com.oliveira.emanoel.events.presentation.ui.screens

import android.content.Intent
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.domain.model.EventCheckIn
import br.com.oliveira.emanoel.events.presentation.BaseApplication
import br.com.oliveira.emanoel.events.repository.EventsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class EventsViewModel
@Inject
constructor(
    private val repository: EventsRepository
) : ViewModel() {
    val events: MutableState<List<Event>> = mutableStateOf(listOf())
    val userName = mutableStateOf("")
    val userEmail = mutableStateOf("")
    val app = BaseApplication()

    init {

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { repository.getEvents() }

            events.value = result
        }
    }

    fun onChangedUserName(userName: String) {
        this.userName.value = userName
    }

    fun onChangedUserEmail(email: String) {
        this.userEmail.value = email
    }

    fun checkIn(eventCheckIn: EventCheckIn) {

        viewModelScope.launch {
            try {
                val responseCode =
                    withContext(Dispatchers.IO) { repository.postCheckIn(eventCheckIn) }

            } catch (e: Exception) {
                e.message?.let { Log.d("CHECKIN", it) }
            }
        }
    }

    fun validateInputs(): Boolean {
        val isValid: Boolean
        if (userName.value.isEmpty() ||
            userName.value.isBlank() ||
            userName.value.equals("Campo obrigatório!")
        ) {
            userName.value = ""
            userName.value = "Campo obrigatório!"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail.value).matches()
        ) {
            userEmail.value = ""
            userEmail.value = "Email inválido!"
            isValid = false
        } else isValid = true

        return isValid
    }

}

