package com.my.klm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Country(

    val areaCode: String,
    val code: String,
    val name: String,
    val nameLangTranl: String,
    val euroCountry: String,
    val euCountry: String
) : Parcelable