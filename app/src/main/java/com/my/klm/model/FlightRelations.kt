package com.my.klm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FlightRelations(

    val previousFlightData: PreviousFlightData?
) : Parcelable