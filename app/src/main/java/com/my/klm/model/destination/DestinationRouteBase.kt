package com.my.klm.model.destination

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class DestinationRouteBase(

    val destinations: List<Destinations>,
    val countries: List<Countries>,
    val regions: List<Regions>,
    val airports: List<Airports>,
    val urls: Urls
) : Parcelable