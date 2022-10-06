package br.com.oliveira.emanoel.events.presentation.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.oliveira.emanoel.events.domain.model.Event
import br.com.oliveira.emanoel.events.presentation.ui.theme.Background
import br.com.oliveira.emanoel.events.utils.DateMillisConverter


@Composable
fun EventCard(item: Event, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(250.dp)
            .clickable { clickAction.invoke() }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(),

        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            EventImage(item, 250.dp)
            Column(
                modifier = Modifier
                    .height(60.dp)
                    .background(Color(Background.value))
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),

                ) {
                item.title?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                item.date?.let {

                    Text(
                        text = DateMillisConverter(it),
                        modifier = Modifier
                            .padding(start = 8.dp),
                        color = Color.LightGray,

                        )
                }
            }
        }

    }
}



