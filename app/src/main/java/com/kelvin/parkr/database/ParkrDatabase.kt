package com.kelvin.parkr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kelvin.parkr.model.Parking
import com.kelvin.parkr.model.Vehicle

@Database(entities = [Vehicle::class, Parking::class], version = 1)
@TypeConverters(Converters::class)
abstract class ParkrDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao
    abstract fun parkingDao(): ParkingDao

    companion object {
        private var INSTANCE: ParkrDatabase? = null
        private const val DB_NAME = "PARKR_DB"

        // database is a singleton
        fun getDatabase(context: Context): ParkrDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder<ParkrDatabase>(
                    context.applicationContext,
                    ParkrDatabase::class.java,
                    DB_NAME
                )
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}