package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Temperature(

    val value: Int,
    val unit: String
) : Parcelable