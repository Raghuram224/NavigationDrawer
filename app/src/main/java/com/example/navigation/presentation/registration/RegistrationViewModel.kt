package com.example.navigation.presentation.registration


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {
    //
//    var registrationState = MutableStateFlow(RegistrationState())
//        private set
    var registrationState by mutableStateOf(RegistrationState())
        private set


    fun onRegistrationEvent(events: RegistrationEvents) {
        when (events) {
            is RegistrationEvents.Register -> {
                // Handle registration logic
                Log.i("register",registrationState.toString())
            }

            is RegistrationEvents.UpdateDob -> {
                registrationState = registrationState.copy(dob = events.dob)
            }

            is RegistrationEvents.UpdateEmail -> {
                registrationState = registrationState.copy(email = events.email)
            }

            is RegistrationEvents.UpdateGender -> {
                registrationState = registrationState.copy(gender = events.gender)
            }

            is RegistrationEvents.UpdatePhone -> {
                registrationState = registrationState.copy(phone = events.mobile)
            }

            is RegistrationEvents.UpdateName -> {
                registrationState = registrationState.copy(name = events.name)
            }

            is RegistrationEvents.UpdatePinCode -> {
                registrationState = registrationState.copy(pinCode = events.pinCode)
            }

            is RegistrationEvents.UpdateSchool -> {
                registrationState = registrationState.copy(applyingSchoolOf = events.school)
            }
        }
    }
}