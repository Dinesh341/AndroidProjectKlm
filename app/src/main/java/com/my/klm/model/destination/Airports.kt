package com.my.klm.model.destination

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Airports(
    val code: String,
    val cityCode: String,
    val airportLabel: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable