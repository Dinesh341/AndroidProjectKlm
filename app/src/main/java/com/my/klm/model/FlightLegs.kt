package com.my.klm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FlightLegs(

    val status: String,
    val statusName: String,
    val publishedStatus: String,
    val departureInformation: DepartureInformation?,
    val arrivalInformation: ArrivalInformation?,
    val legStatusPublic: String,
    val legStatusPublicLangTransl: String,
    val passengerCustomsStatus: String,
    val serviceType: String,
    val serviceTypeName: String,
    val scheduledFlightDuration: String,
    val completionPercentage: Int,
    val timeZoneDifference: Int,
    val aircraft: Aircraft?,
    val irregularity: Irregularity?,
    val internalLegStatusArrFocus: Boolean
) : Parcelable