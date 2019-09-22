package com.kelvin.parkr.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vehicle(
    @PrimaryKey var licensePlate: String = "",
    var make: String?,
    var model: String?,
    var color: String?
)