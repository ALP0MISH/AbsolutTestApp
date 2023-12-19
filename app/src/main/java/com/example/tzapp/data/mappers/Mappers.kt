package com.example.tzapp.data.mappers

import com.example.tzapp.data.cache.models.UserCache
import com.example.tzapp.domain.models.UserDomain

fun UserDomain.toCache(): UserCache =
    this.run {
        UserCache(
            id = id,
            name = name,
            emailOrNumber = emailOrNumber,
            institutionName = institutionName,
            cityName = cityName,
            address = address,
            totalArea = totalArea,
            numberOfSeats = numberOfSeats,
            areaOfHalls = areaOfHalls,
            areaKitchen = areaKitchen,
            automationSystem = automationSystem, restaurant = restaurant,
            bar = bar,
            coffee = coffee,
            coffeeHouse = coffeeHouse,
            canteen = canteen,
            cooking = cooking,
            other = other,
            delivery = delivery,
            inInstitution = inInstitution,
            takeAway = takeAway
        )
    }