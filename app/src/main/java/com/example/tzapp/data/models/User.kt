package com.example.tzapp.data.models

data class User(
    val id: Int? = null,
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
) {
    companion object {
        val unknown = User(
            id = 0,
            name = "",
            emailOrNumber = "",
            inInstitution = false,
            cityName = "",
            address = "",
            totalArea = "",
            numberOfSeats = "",
            areaKitchen = "",
            areaOfHalls = "",
            automationSystem = "",
            restaurant = false,
            bar = false,
            coffee = false,
            coffeeHouse = false,
            canteen = false,
            cooking = false,
            other = false,
            takeAway = false,
            delivery = false,
            institutionName = ""
        )
    }
}
