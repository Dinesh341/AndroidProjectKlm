package com.my.klm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FlightStatusData(

    val flightNumber: Int,
    val flightScheduleDate: String,
    val id: String,
    val route: List<String>?,
    val airline: Airline,
    val flightRelations: FlightRelations?,
    val flightStatusPublic: String,
    val flightStatusPublicLangTransl: String,
    val flightLegs: List<FlightLegs>?,
    val internalStatusArrFocus: Boolean
) : Parcelable