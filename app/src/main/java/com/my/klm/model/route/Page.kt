package com.my.klm.model.route

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Page(

    val pageSize: Int?,
    val pageNumber: Int?,
    val fullCount: Int?,
    val pageCount: Int?,
    val totalPages: Int?
) : Parcelable