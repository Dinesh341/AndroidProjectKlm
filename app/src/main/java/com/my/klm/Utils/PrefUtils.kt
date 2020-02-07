package com.my.klm.Utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import android.text.TextUtils
import android.util.Log
import com.my.klm.R
import kotlinx.android.synthetic.main.flightstatus_activity.*


object PrefUtils {
    /**
     * Helper method to retrieve a String value from [SharedPreferences].
     *
     * @param context a [Context] object.
     * @return The value from shared preferences, or null if the value could not be read.
     */
    fun getStringPreference(context: Context?, key: String?): String? {
        var value: String? = null
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            value = preferences.getString(key, null)
        }
        return value
    }


    /**
     * Helper method to write a String value to [SharedPreferences].
     *
     * @param context a [Context] object.
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setStringPreference(
        context: Context?,
        key: String?,
        value: String?
    ): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            editor.putString(key, value)
            return editor.commit()
        }
        return false
    }

    /**
     * Checks if there's internet connection on the phone
     * @param context To initiate [ConnectivityManager]
     * @return True if network is available
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager
            .activeNetworkInfo.isConnected
    }

    fun validateFlightNumber(flightNumber: String) : Boolean {
        return flightNumber.length == 6
    }

    fun validateDateText(date: String):Boolean{
        return date.equals("Select Date")
    }

    fun validateFromToDate(date: String):Boolean{
        return date.equals("Start Date") || date.equals("End Date")
    }
}