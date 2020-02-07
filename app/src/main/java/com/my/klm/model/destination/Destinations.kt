package com.my.klm.model.destination

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Destinations(

    val code: String,
    val label: String,
    val title: String,
    val picture: Picture,
    val travelGuide: TravelGuide,
    val latitude: Double,
    val longitude: Double,
    val countryCode: String,
    val regionCode: String,
    val isNewDestination: Boolean
) : Parcelable