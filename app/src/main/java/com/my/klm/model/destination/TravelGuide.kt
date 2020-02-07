package com.my.klm.model.destination

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize

data class TravelGuide(

    val isTravelGuideAvailable: Boolean,
    val travelGuideUrl: String
) : Parcelable