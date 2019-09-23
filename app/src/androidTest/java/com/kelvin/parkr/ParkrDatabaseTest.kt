package com.kelvin.parkr

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.android.gms.maps.model.LatLng
import com.kelvin.parkr.database.ParkingDao
import com.kelvin.parkr.database.ParkrDatabase
import com.kelvin.parkr.database.VehicleDao
import com.kelvin.parkr.model.Parking
import com.kelvin.parkr.model.Vehicle
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class ParkrDatabaseTest {

    private lateinit var testDatabase: ParkrDatabase
    private lateinit var vehicleDao: VehicleDao
    private lateinit var parkingDao: ParkingDao

    private val firstVehicle = Vehicle("VVV 111", "Tesla", "Model 3", "black")
    private val secondVehicle = Vehicle("123 ABC", null, null, null)
    private val firstParking = Parking(
        vehicle = firstVehicle,
        latLng = LatLng(493.9, 312.33),
        timeStarted = null,
        durationPaidMs = null,
        stallNumber = 312,
        level = 2,
        lotPhoneNumber = "604-123-4567",
        notes = "I parked here"
    )
    private val secondParking = Parking(
        vehicle = secondVehicle,
        latLng = LatLng(-100.9, 312.33),
        timeStarted = Date(888888),
        durationPaidMs = 600000,
        stallNumber = null,
        level = null,
        lotPhoneNumber = null,
        notes = null
    )
    private val thirdParking = Parking(
        vehicle = secondVehicle,
        latLng = LatLng(212.9, 31.33),
        timeStarted = null,
        durationPaidMs = 600000,
        stallNumber = 21,
        level = 4,
        lotPhoneNumber = null,
        notes = null
    )

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().context
        testDatabase = Room.inMemoryDatabaseBuilder(context, ParkrDatabase::class.java).build()
        vehicleDao = testDatabase.vehicleDao()
        parkingDao = testDatabase.parkingDao()
    }

    @After
    fun closeDb() {
        testDatabase.close()
    }

    @Test
    fun testVehicleDao_insertVehicle_sizeUpdate() = runBlocking {
        vehicleDao.insertVehicle(firstVehicle)
        vehicleDao.insertVehicle(secondVehicle)

        val allVehiclesFromDb = vehicleDao.loadAllVehicles()
        Assert.assertTrue(allVehiclesFromDb.size == 2)

        vehicleDao.deleteVehicle(firstVehicle)
        Assert.assertTrue(vehicleDao.findVehicleByLicensePlate(firstVehicle.licensePlate).isEmpty())
    }

    @Test
    fun testVehicleDao_findVehicleByLicense_findSuccess() = runBlocking {
        vehicleDao.insertVehicle(firstVehicle)
        vehicleDao.insertVehicle(secondVehicle)
        val firstVehicleFromDb = vehicleDao.findVehicleByLicensePlate(firstVehicle.licensePlate)
        Assert.assertEquals(firstVehicle, firstVehicleFromDb[0])

        val secondVehicleFromDb = vehicleDao.findVehicleByLicensePlate(secondVehicle.licensePlate)
        Assert.assertEquals(secondVehicle, secondVehicleFromDb[0])
    }

    @Test
    fun testVehicleDao_deleteVehicle_vehicleGoneAndSizeDecrease() = runBlocking {
        vehicleDao.insertVehicle(firstVehicle)
        vehicleDao.insertVehicle(secondVehicle)
        vehicleDao.deleteVehicle(firstVehicle)
        Assert.assertTrue(vehicleDao.findVehicleByLicensePlate(firstVehicle.licensePlate).isEmpty())
        val allVehiclesFromDb = vehicleDao.loadAllVehicles()
        Assert.assertTrue(allVehiclesFromDb.size == 1)
    }

    @Test
    fun testParkingDao_insertParking_sizeUpdate() = runBlocking {
        parkingDao.insertParking(firstParking)
        parkingDao.insertParking(secondParking)

        val allParkingFromDb = parkingDao.loadAllParking()

        Assert.assertTrue(allParkingFromDb.size == 2)
    }

    @Test
    fun testParkingDao_findParkingById_findSuccess() = runBlocking {
        val thirdParkingId = parkingDao.insertParking(thirdParking)
        parkingDao.insertParking(secondParking)

        val thirdParkingFromDb = parkingDao.findParkingById(thirdParkingId)
        Assert.assertEquals(thirdParking, thirdParkingFromDb[0])
    }
}