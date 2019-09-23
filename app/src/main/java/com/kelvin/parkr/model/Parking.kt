package com.kelvin.parkr.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import java.util.Date

@Entity
data class Parking(
    var vehicle: Vehicle,
    var latLng: LatLng,
    var timeStarted: Date?,
    var durationPaidMs: Long?,
    var stallNumber: Int?,
    var level: Int?,
    var lotPhoneNumber: String?,
    var notes: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}