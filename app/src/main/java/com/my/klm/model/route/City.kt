package com.my.klm.model.route

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class City(

    @Expose @SerializedName("code") val code: String?,
    val name: String?,
    val nameLangTranl: String?,
    val country: Country?
) : Parcelable