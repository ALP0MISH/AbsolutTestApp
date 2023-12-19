package com.example.tzapp.presentation.screens.onboarding

import com.example.tzapp.domain.models.UserDomain


data class OnboardingUiState(
    val id: Int = 0,
    val name: String = String(),
    val emailOrNumber: String = String(),
    val inInstitution: Boolean = false,
    val institutionName: String = String(),
    val cityName: String = String(),
    val address: String = String(),
    val totalArea: String = String(),
    val numberOfSeats: String = String(),
    val areaOfHalls: String = String(),
    val areaKitchen: String = String(),
    val automationSystem: String = String(),
    val restaurant: Boolean = false,
    val bar: Boolean = false,
    val coffee: Boolean = false,
    val coffeeHouse: Boolean = false,
    val canteen: Boolean = false,
    val takeAway: Boolean = false,
    val delivery: Boolean = false,
    val cooking: Boolean = false,
    val other: Boolean = false,
)