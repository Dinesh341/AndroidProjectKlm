package com.my.klm

import android.app.Application
import android.content.Context


class KlmApplication : Application() {

    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }

}
