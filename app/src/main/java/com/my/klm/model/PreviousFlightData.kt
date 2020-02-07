package com.my.klm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PreviousFlightData (

	@SerializedName("id") val id : String,
	@SerializedName("flightScheduleDate") val flightScheduleDate : String,
	@SerializedName("airlineCode") val airlineCode : String,
	@SerializedName("flightNumber") val flightNumber : Int
): Parcelable