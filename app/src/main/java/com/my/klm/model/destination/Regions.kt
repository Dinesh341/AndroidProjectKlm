package com.my.klm.model.destination

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Regions(

    val code: String,
    val regionLabel: String,
    val pictureUrl: String,
    val latitude: Double,
    val longitude: Double,
    val travelGuide: TravelGuide
) : Parcelable