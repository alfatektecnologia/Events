package br.com.oliveira.emanoel.events.presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import br.com.oliveira.emanoel.events.R
import br.com.oliveira.emanoel.events.domain.model.Event
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

@Composable
@OptIn(ExperimentalCoilApi::class)
fun EventImage(item: Event?, sizeHeight: Dp) {
    val painter = rememberImagePainter(data = item?.image,
        builder = {
            placeholder(R.drawable.logomarca_sicredi)
            error(R.drawable.ic_error_24)
            crossfade(1000)
        }
    )
    val painterState = painter.state
    if (painterState is ImagePainter.State.Loading) {

        CircularProgressIndicator(
            color = Color.White
        )
    }
    Image(
        painter = painter,
        contentDescription = "image as background",
        modifier = Modifier
            .height(sizeHeight),
        contentScale = ContentScale.FillHeight
    )

}