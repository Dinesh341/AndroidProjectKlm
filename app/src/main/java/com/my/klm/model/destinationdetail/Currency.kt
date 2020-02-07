package com.my.klm.model.destinationdetail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize

data class Currency(

    val data: Datas
) : Parcelable