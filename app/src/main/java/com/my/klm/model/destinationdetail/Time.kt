package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Time(

    val timeZone: String,
    val jetLag: String
) : Parcelable