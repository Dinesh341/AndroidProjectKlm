package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Data(

    val description: Description,
    val isDayTime: Boolean,
    val temperature: List<Temperature>
) : Parcelable