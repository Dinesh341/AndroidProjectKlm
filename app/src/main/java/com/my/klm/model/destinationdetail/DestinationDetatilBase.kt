package com.my.klm.model.destinationdetail

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DestinationDetatilBase(

    val cityCode: String,
    val originCity: OriginCity,
    val effectiveFlightDuration: String,
    val spokenLanguages: List<SpokenLanguages>,
    val time: Time,
    val weather: Weather,
    val currency: Currency,
    val travelGuide: TravelsGuide
) : Parcelable