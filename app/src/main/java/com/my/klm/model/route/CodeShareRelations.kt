package com.my.klm.model.route

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class CodeShareRelations(

    val marketingFlightNumber: Int?,
    val flightScheduleDate: String?,
    val code: String?,
    val type: String?,
    val airline: Airline?
) : Parcelable