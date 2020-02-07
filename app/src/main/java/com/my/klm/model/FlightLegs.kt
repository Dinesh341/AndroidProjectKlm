package com.my.klm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.my.klm.model.Aircraft
import com.my.klm.model.ArrivalInformation
import com.my.klm.model.DepartureInformation
import com.my.klm.model.Irregularity
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