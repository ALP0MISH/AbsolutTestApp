package com.example.tzapp.domain.models

data class UserDomain(
    val id: Int,
    val name: String,
    val emailOrNumber: String,
    val institutionName: String,
    val cityName: String,
    val address: String,
    val totalArea: String,
    val numberOfSeats: String,
    val areaOfHalls: String,
    val areaKitchen: String,
    val automationSystem: String,
    val restaurant: Boolean,
    val bar: Boolean,
    val coffee: Boolean,
    val coffeeHouse: Boolean,
    val canteen: Boolean,
    val cooking: Boolean,
    val other: Boolean,
    val takeAway: Boolean,
    val delivery: Boolean,
    val inInstitution: Boolean
)
