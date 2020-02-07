package com.my.klm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



@Parcelize
data class Irregularity (

	@SerializedName("cancelled") val cancelled : String
) : Parcelable