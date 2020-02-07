package com.my.klm.model.destination

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Countries(

    val code: String,
    val countryLabel: String,
    val pictureUrl: String,
    val latitude: Double,
    val longitude: Double,
    val travelGuide: TravelGuide
) : Parcelable