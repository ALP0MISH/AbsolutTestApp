package com.example.tzapp.presentation.utils

private fun validateMinLength(input: String, minLength: Int): Boolean {
    val pattern = Regex(".{$minLength,}")
    return input.matches(pattern)
}

fun validateNameAndEmail(name: String, email: String): Boolean {
    val emailPattern = Regex("[a-zA-Z0-9]+@(gmail\\.com|mail\\.ru)")
    return validateMinLength(name, 6) && email.matches(emailPattern)
}

fun validateInstitutionCityAndAddress(institution: String, city: String, address: String): Boolean {
    return validateMinLength(institution, 4) &&
            validateMinLength(city, 2) &&
            validateMinLength(address, 2)
}