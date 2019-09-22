package com.kelvin.parkr

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.kelvin.parkr.database.ParkrDatabase
import com.kelvin.parkr.database.VehicleDao
import com.kelvin.parkr.model.Vehicle
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ParkrDatabaseTest {

    private lateinit var testDatabase: ParkrDatabase
    private lateinit var vehicleDao: VehicleDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().context
        testDatabase = Room.inMemoryDatabaseBuilder(context, ParkrDatabase::class.java).build()
        vehicleDao = testDatabase.vehicleDao()
    }

    @After
    fun closeDb() {
        testDatabase.close()
    }

    @Test
    fun testVehicleDaoQueries() = runBlocking {
        val vehicle1 = Vehicle("VVV 111", "Tesla", "Model 3", "black")
        vehicleDao.insertVehicle(vehicle1)
        val vehicle2 = Vehicle("123 ABC", null, null, null)
        vehicleDao.insertVehicle(vehicle2)

        val vehicle1FromDb = vehicleDao.findVehicleByLicensePlate("VVV 111")
        Assert.assertEquals(vehicle1, vehicle1FromDb)
    }
}