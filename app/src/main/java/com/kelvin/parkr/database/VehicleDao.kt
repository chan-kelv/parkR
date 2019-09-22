package com.kelvin.parkr.database

import androidx.room.*
import com.kelvin.parkr.model.Vehicle

@Dao
public interface VehicleDao {

    @Query("SELECT * FROM Vehicle WHERE licensePlate =:licensePlate")
    suspend fun findVehicleByLicensePlate(licensePlate: String): Vehicle

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)
}