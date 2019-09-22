package com.kelvin.parkr.database

import androidx.room.TypeConverter
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.kelvin.parkr.model.Vehicle
import java.util.Date

class Converters {
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time

    @TypeConverter
    fun timestampToDate(value: Long?): Date? = if (value == null) null else Date(value)

    @TypeConverter
    fun latLngToString(latLng: LatLng): String = Gson().toJson(latLng)

    @TypeConverter
    fun stringToLatLng(value: String): LatLng = Gson().fromJson(value, LatLng::class.java)

    @TypeConverter
    fun vehicleToString(vehicle: Vehicle): String = Gson().toJson(vehicle)

    @TypeConverter
    fun stringToVehicle(value: String): Vehicle = Gson().fromJson(value, Vehicle::class.java)
}