package br.com.oliveira.emanoel.events.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.presentation.ui.screens.EventsViewModel
import br.com.oliveira.emanoel.events.presentation.ui.theme.Background
import br.com.oliveira.emanoel.events.presentation.ui.theme.DarkGreen
import br.com.oliveira.emanoel.events.presentation.ui.theme.LightGreen
import br.com.oliveira.emanoel.events.utils.DateMillisConverter
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetail(viewModel: EventsViewModel, eventId: String?, navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(DarkGreen.value),
        topBar = {
            AppBar(
                title = "Detalhe do evento",
                icon = Icons.Default.ArrowBack,
                actionIcon = Icons.Default.Share,
                actionIconClick = {}

            ) {
                //onclickAction
                navController.navigateUp()
            }

        },
        content = {
            val paddingValue = it
            val event: Event? = viewModel.events.value.find { it.id.equals(eventId) }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValue)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EventImage(event, 200.dp)
                Spacer(modifier = Modifier.height(8.dp))
                event?.title?.let { title ->
                    Text(
                        text = title,
                        modifier = Modifier.padding(start = 0.dp, top = 8.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                event?.date?.let { date ->

                    Text(
                        text = DateMillisConverter(date),
                        modifier = Modifier
                            .padding(start = 8.dp),
                        color = Color.LightGray,

                        )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .background(Color(Background.value))
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(8.dp))
                    event?.description?.let { description ->
                        Text(
                            text = description,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                event?.price?.let { price ->
                    val newPrice = String.format("%.2f", price)
                    Text(
                        text = "Ingresso: R$$newPrice".format(Locale.getDefault(), 2),
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .fillMaxWidth()

                ) {
                    Button(
                        onClick = { navController.navigate("checkin_dialog/${eventId}") },
                        modifier = Modifier
                            .background(Color(LightGreen.value))
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(LightGreen.value))
                    ) {
                        Text(text = "Check in".uppercase())
                    }

                }

                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .fillMaxWidth()

                ) {
                    Button(
                        onClick = {
                            val latitude = event?.latitude?.toLong()
                            val longitude = event?.longitude?.toLong()
                            navController.navigate("maps/${latitude}/${longitude}")
                        },
                        modifier = Modifier
                            .border(2.dp, color = Color.White)
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "localização".uppercase())
                    }

                }

            }
        }

    )
}