package br.com.oliveira.emanoel.events.presentation.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    icon: ImageVector?,
    actionIcon: ImageVector?,
    actionIconClick: () -> Unit,
    iconClickAction: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            icon?.let {
                Icon(
                    imageVector = it, "icone",
                    modifier = Modifier
                        .clickable { iconClickAction.invoke() }
                        .padding(start = 16.dp),
                    tint = Color.White
                )
            }
        },
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = Color.White,
                )
            }
        },
        actions = {
            actionIcon?.let {
                Icon(
                    imageVector = it, "icone",
                    modifier = Modifier
                        .clickable { actionIconClick.invoke() }
                        .padding(end = 16.dp),
                    tint = Color.White
                )
            }
        }
    )
}