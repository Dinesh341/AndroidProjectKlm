package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Datas(

    val code: String,
    val label: String,
    val symbol: String
) : Parcelable