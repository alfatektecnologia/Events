package br.com.oliveira.emanoel.events.presentation.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.com.oliveira.emanoel.events.presentation.ui.theme.DarkGreen
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventMaps(
    latitude: Double,
    longitude: Double,
    navController: NavController
) {
    val localization = LatLng(latitude.toDouble(), longitude.toDouble())
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(localization, 12f)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(DarkGreen.value),
        topBar = {
            AppBar(
                title = "Localização",
                icon = Icons.Default.ArrowBack,
                actionIcon = null,
                actionIconClick = {}
            ) {
                //onClickAction
                navController.navigateUp()
            }
        },
    ) {
        it
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = localization),
                title = "Evento",
                snippet = "Marker no evento"
            )
        }
    }

}