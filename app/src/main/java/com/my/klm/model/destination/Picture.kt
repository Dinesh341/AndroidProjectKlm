package com.my.klm.model.destination

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Picture(

    val imageUrl: String,
    val imageCaption: String,
    val imageAccessibility: String
) : Parcelable