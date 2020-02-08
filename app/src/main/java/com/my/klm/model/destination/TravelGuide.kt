package com.my.klm.model.destination

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class TravelGuide(

    val isTravelGuideAvailable: Boolean,
    val travelGuideUrl: String
) : Parcelable