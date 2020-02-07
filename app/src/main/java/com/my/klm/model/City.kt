package com.my.klm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class City(

    val code: String,
    val name: String,
    val nameLangTranl: String,
    val country: Country?
) : Parcelable