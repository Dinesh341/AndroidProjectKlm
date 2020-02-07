package com.my.klm.model.destination

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Urls(

    val homepage: String
) : Parcelable