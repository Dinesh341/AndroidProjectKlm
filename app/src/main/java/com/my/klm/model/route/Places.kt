package com.my.klm.model.route

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Places(
    val aerogareCode: String?,
    val parkingPosition: String?,
    val pierCode: String?,
    val terminalCode: String?,
    val baggageBelt: List<String>?,
    val arrivalPositionTerminal: String?,
    val parkingPositionType: String?,
    val arrivalTerminal: String?,
    val parkingPositionCustomStatus: String?,
    val disembarkingContactType: String?,
    val disembarkingAerogare: String?
) : Parcelable