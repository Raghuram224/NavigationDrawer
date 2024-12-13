package com.example.navigation.presentation.registration

data class RegistrationState(
    val name: String="",
    val email: String="",
    val phone: String="",
    val dob: String? =null,
    val gender: String?=null,
    val pinCode: String="",
    val applyingSchoolOf: Schools = Schools.Empty
)

enum class Schools{
    SchoolOfTechnology,
    SchoolOfBusiness,
    SchoolOfDesign,
    Empty
}