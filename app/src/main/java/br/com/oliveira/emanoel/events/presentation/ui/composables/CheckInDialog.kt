package br.com.oliveira.emanoel.events.presentation.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import br.com.oliveira.emanoel.events.domain.model.EventCheckIn
import br.com.oliveira.emanoel.events.presentation.ui.screens.EventsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckInDialog(eventId: String?, navController: NavController, viewModel: EventsViewModel) {

    Dialog(
        onDismissRequest = { navController.navigateUp() },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Check in",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "",
                            tint = colorResource(android.R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { navController.navigateUp() }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = viewModel.userName.value,
                        onValueChange = { viewModel.onChangedUserName(it) },
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = { Text(text = "Nome") },
                        singleLine = true,
                        placeholder = { Text(text = "Digite seu nome") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = viewModel.userEmail.value,
                        onValueChange = { viewModel.onChangedUserEmail(it) },
                        modifier = Modifier
                            .fillMaxWidth(),
                        label = { Text(text = "E-mail") },
                        singleLine = true,
                        placeholder = { Text(text = "Digite seu e-mail") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                val isValidated = viewModel.validateInputs()
                                if (isValidated) {
                                    val checkIn = EventCheckIn(
                                        eventId = eventId,
                                        name = viewModel.userName.value,
                                        email = viewModel.userEmail.value
                                    )
                                    viewModel.checkIn(checkIn)
                                    navController.navigateUp()
                                }

                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Done")
                        }
                    }
                }
            }
        }
    }
}