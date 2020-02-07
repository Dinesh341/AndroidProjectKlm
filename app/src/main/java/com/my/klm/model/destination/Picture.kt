package com.my.klm.model.destination

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Picture(

    val imageUrl: String,
    val imageCaption: String,
    val imageAccessibility: String
) : Parcelable