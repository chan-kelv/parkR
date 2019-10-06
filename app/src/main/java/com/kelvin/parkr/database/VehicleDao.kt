package com.kelvin.parkr.database

import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import com.kelvin.parkr.model.Vehicle

@Dao
interface VehicleDao {

    @Query("SELECT * FROM Vehicle WHERE licensePlate =:licensePlate")
    suspend fun findVehicleByLicensePlate(licensePlate: String): List<Vehicle>

    @Query("SELECT * FROM Vehicle")
    suspend fun loadAllVehicles(): List<Vehicle>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)
}