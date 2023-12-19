package com.example.tzapp.data.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "use_table"
)
data class UserCache(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int? = null,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("emailOrNumber") val emailOrNumber: String,
    @ColumnInfo("institutionName") val institutionName: String,
    @ColumnInfo("cityName") val cityName: String,
    @ColumnInfo("address") val address: String,
    @ColumnInfo("totalArea") val totalArea: String,
    @ColumnInfo("numberOfSeats") val numberOfSeats: String,
    @ColumnInfo("areaOfHalls") val areaOfHalls: String,
    @ColumnInfo("areaKitchen") val areaKitchen: String,
    @ColumnInfo("automationSystem") val automationSystem: String,
    @ColumnInfo("restaurant")  val restaurant: Boolean,
    @ColumnInfo("bar") val bar: Boolean,
    @ColumnInfo("coffee") val coffee: Boolean,
    @ColumnInfo("coffeeHouse")  val coffeeHouse: Boolean,
    @ColumnInfo("canteen")  val canteen: Boolean,
    @ColumnInfo("cooking")  val cooking: Boolean,
    @ColumnInfo("other") val other: Boolean,
    @ColumnInfo("takeAway") val takeAway: Boolean,
    @ColumnInfo("delivery") val delivery: Boolean,
    @ColumnInfo("inInstitution") val inInstitution: Boolean,
)