package com.my.klm

import FlightStatusData
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.klm.ViewModels.FlightViewModel
import com.my.klm.Utils.PrefUtils
import kotlinx.android.synthetic.main.flightstatus_activity.*
import java.text.SimpleDateFormat
import java.util.*

class FlightStatusActivity : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flightstatus_activity)
        mAndroidViewModel =
            ViewModelProviders.of(this@FlightStatusActivity).get(FlightViewModel::class.java)
        searchflight.setOnClickListener {
            if(PrefUtils.isNetworkAvailable(this)) {
                searchFlightNumber()
            }else{
                showErrorMessage(getString(R.string.internet_check))
            }
        }
        initTokenObservers()
        setUpCalender()
    }

    /**
     * Get the Flight details based on the flight number and Date
     */
    private fun searchFlightNumber() {
        var tokenValue = PrefUtils.getStringPreference(this, getString(R.string.token))
        tokenValue = "Bearer " + tokenValue
        var date = selectDate.text.toString().trim()
        if (flightno.text.length == 6 && !date.equals(getString(R.string.select_date))) {
            progress_circular.visibility = View.VISIBLE
            mAndroidViewModel?.getFlightList(progress_circular,
                "/travel/flightstatus/${flightno.text.toString().toUpperCase()}" + "+${date}",
                "AMS",
                "true",
                tokenValue.toString()
            )
        } else {
            if (!(flightno.text.length == 6)) {
               showErrorMessage(getString(R.string.error_flight))
            } else if (date.equals(getString(R.string.select_date))) {
                showErrorMessage(getString(R.string.error_date))
            }
        }
    }

    /**
     * Show the Error Message
     */
    private fun showErrorMessage(errorMessage : String) {
        val toast = Toast.makeText(
            applicationContext,
            errorMessage,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }

    /**
     * Set the Calender Instance
     */
    private fun setUpCalender() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        selectDate.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val myFormat = "yyyy-MM-dd" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    selectDate!!.text = sdf.format(cal.getTime())
                },
                year,
                month,
                day
            )
            dpd.show()
        }
    }

    /**
     * Observer for Flight status details.
     */
    private fun initTokenObservers() {
        mAndroidViewModel?.getFlightData()?.observe(this, Observer {
            it?.let {
                progress_circular.visibility = View.GONE
                sendData(it)
            }
        })
    }

    /**
     * Share the Flight data into Flight detail view
     */
    private fun sendData(it: FlightStatusData) {
        val intent = Intent(this, FlightDetailView::class.java)
        intent.putExtra(getString(R.string.flightdata), it)
        startActivity(intent)
    }

}
