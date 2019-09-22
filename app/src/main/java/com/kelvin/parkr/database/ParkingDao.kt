package com.kelvin.parkr.database

import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import com.kelvin.parkr.model.Parking

@Dao
interface ParkingDao {

    @Query("SELECT * FROM Parking WHERE id =:id")
    suspend fun findParkingById(id: Long): List<Parking>


    @Query("SELECT * FROM Parking")
    suspend fun loadAllParking(): List<Parking>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParking(parking: Parking): Long

    @Delete
    suspend fun deleteParking(parking: Parking)
}