package com.my.klm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Location (

	@SerializedName("latitude") val latitude : Double,
	@SerializedName("longitude") val longitude : Double
): Parcelable