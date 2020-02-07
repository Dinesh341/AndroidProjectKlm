package com.my.klm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DepartureInformation(

    val airport: Airport?,
    val times: Times?
) : Parcelable