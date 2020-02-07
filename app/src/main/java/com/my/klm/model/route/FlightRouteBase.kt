package com.my.klm.model.route

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlightRouteBase(
    val operationalFlights: List<OperationalFlights>?,
    val page: Page?
) : Parcelable