package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class TravelsGuide(

    val isTravelGuideAvailable: Boolean,
    val travelGuideUrl: String
) : Parcelable