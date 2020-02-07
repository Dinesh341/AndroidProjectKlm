package com.my.klm.model.route

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OperationalFlights(
    val flightNumber: Int?,
    val flightScheduleDate: String?,
    val id: String?,
    val haul: String?,
    val route: List<String>?,
    val airline: Airline?,
    val codeShareRelations: List<CodeShareRelations>?,
    val flightRelations: FlightRelations?,
    val flightStatusPublic: String?,
    val flightStatusPublicLangTransl: String?,
    val flightLegs: List<FlightLegs>?,
    val internalStatusArrFocus: Boolean?
) : Parcelable