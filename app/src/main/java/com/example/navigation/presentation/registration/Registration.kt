package com.example.navigation.presentation.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Registration(
    modifier: Modifier = Modifier,
    state: RegistrationState,
    onAction:(RegistrationEvents)-> Unit
) {


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = state.name,
            onValueChange = {onAction(RegistrationEvents.UpdateName(it))},
            placeholder = {Text("name")}

        )
        OutlinedTextField(
            value = state.email,
            onValueChange = {onAction(RegistrationEvents.UpdateEmail(it))},
            placeholder = {Text("Email")}

        )
        OutlinedTextField(
            value = state.phone,
            onValueChange = {onAction(RegistrationEvents.UpdatePhone(it))},
            placeholder = {Text("Phone")}

        )

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {onAction(RegistrationEvents.Register)}
        ) {
            Text("Register")
        }


    }

}


