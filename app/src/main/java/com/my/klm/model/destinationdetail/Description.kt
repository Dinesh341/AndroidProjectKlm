package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Description(

    val code: String,
    val label: String,
    val pictoUrl: String,
    val pictoUrlSvg: String,
    val description: String
) : Parcelable