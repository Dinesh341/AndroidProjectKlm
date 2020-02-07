package com.my.klm.model.route

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class FlightRelations(

    val onwardFlightData: OnwardFlightData?
) : Parcelable