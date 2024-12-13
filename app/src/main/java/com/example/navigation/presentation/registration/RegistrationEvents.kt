package com.example.navigation.presentation.registration


sealed interface RegistrationEvents {

    data class UpdateEmail(val email: String) : RegistrationEvents
    data class UpdateName(val name: String) : RegistrationEvents
    data class UpdatePhone(val mobile: String) : RegistrationEvents
    data class UpdateGender(val gender: String?) : RegistrationEvents
    data class UpdateDob(val dob: String?) : RegistrationEvents
    data class UpdatePinCode(val pinCode: String) : RegistrationEvents
    data class UpdateSchool(val school: Schools) : RegistrationEvents

    data object Register : RegistrationEvents
}