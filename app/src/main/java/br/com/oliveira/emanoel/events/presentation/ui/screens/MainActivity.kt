package br.com.oliveira.emanoel.events.presentation.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.presentation.ui.composables.*
import br.com.oliveira.emanoel.events.presentation.ui.theme.DarkGreen
import br.com.oliveira.emanoel.events.presentation.ui.theme.EventsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<EventsViewModel>()
            EventsTheme {
                EventsApplication(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun EventsApplication(viewModel: EventsViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "listScreen") {
        composable("listScreen") {
            EventsListScreen(viewModel, navController)
        }
        composable(
            "detailsScreen/{eventId}",
            arguments = listOf(
                navArgument("eventId") { type = NavType.StringType }
            )
        ) {
            val eventId = it.arguments?.getString("eventId")
            EventDetail(viewModel = viewModel, eventId = eventId, navController = navController)
        }
        composable(
            route = "checkin_dialog/{eventId}",
            arguments = listOf(
                navArgument("eventId") { type = NavType.StringType })
        ) {
            val eventId = it.arguments?.getString("eventId")
            CheckInDialog(eventId = eventId, navController = navController, viewModel = viewModel)
        }
        composable(
            route = "maps/{latitude}/{longitude}",
            arguments = listOf(
                navArgument("latitude") { type = NavType.LongType },
                navArgument("longitude") { type = NavType.LongType })
        ) {
            val latitude = it.arguments?.getLong("latitude")
            val longitude = it.arguments?.getLong("longitude")
            EventMaps(
                latitude = latitude!!.toDouble(),
                longitude = longitude!!.toDouble(),
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsListScreen(viewModel: EventsViewModel, navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(DarkGreen.value),
        topBar = {
            AppBar(
                title = "Eventos",
                icon = null,
                actionIcon = null,
                actionIconClick = {}
            ) {
                //icon onClickAction
            }
        },
        content = {

            val paddingFromScaffold = it
            val rememberedEvents: MutableState<List<Event>> = remember { mutableStateOf(listOf()) }
            val events = viewModel.events.value

            rememberedEvents.value = events
            LazyColumn(
                modifier = Modifier
                    .padding(top = 68.dp),
            ) {
                items(rememberedEvents.value) { item ->

                    EventCard(item) {
                        //clickAction
                        navController.navigate("detailsScreen/${item.id}") {

                        }
                    }
                }
            }
        }

    )

}

