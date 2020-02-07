package com.my.klm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Aircraft(

    val typeCode: String?,
    val typeName: String?,
    val subFleetCodeId: String?,
    val ownerAirlineCode: String?,
    val ownerAirlineName: String?,
    val physicalPaxConfiguration: String?,
    val operationalConfiguration: String?,
    val cockpitCrewEmployer: String?,
    val cabinCrewEmployer: String?
) : Parcelable