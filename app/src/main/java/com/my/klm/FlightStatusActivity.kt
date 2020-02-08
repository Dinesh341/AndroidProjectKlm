package com.my.klm

import com.my.klm.model.FlightStatusData
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.my.klm.utils.PrefUtils
import com.my.klm.viewmodels.FlightViewModel
import kotlinx.android.synthetic.main.flightstatus_activity.*
import java.text.SimpleDateFormat
import java.util.*


class FlightStatusActivity : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flightstatus_activity)
        setTitle(R.string.flight_status)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mAndroidViewModel =
            ViewModelProviders.of(this@FlightStatusActivity).get(FlightViewModel::class.java)
        searchflight.setOnClickListener {
            if (PrefUtils.isNetworkAvailable(this)) {
                searchFlightNumber()
            } else {
                PrefUtils.showErrorMessage(this,getString(R.string.internet_check))
            }
        }
        initObservers()

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        flightdate!!.setOnClickListener {
            DatePickerDialog(
                this@FlightStatusActivity,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    /**
     * Get the Flight details based on the flight number and Date
     */
    private fun searchFlightNumber() {
        var tokenValue = PrefUtils.getStringPreference(this, getString(R.string.token))
        tokenValue = getString(R.string.bearer_token, tokenValue)
        val date = flightdate.text.toString().trim()
        if (PrefUtils.validateFlightNumber(flightno.text.toString()) && !PrefUtils.validateDateText(
                date
            )
        ) {
            progress_circular.visibility = View.VISIBLE
            mAndroidViewModel?.getFlightList(
                progress_circular,
                "/travel/flightstatus/${flightno.text.toString().toUpperCase(Locale.getDefault())}" + "+${date}",
                "AMS",
                "true",
                tokenValue.toString()
            )
        } else {
            if (PrefUtils.validateFlightNumber(flightno.text.toString())) {
                PrefUtils.showErrorMessage(this,getString(R.string.error_flight))
            } else if (PrefUtils.validateDateText(date)) {
                PrefUtils.showErrorMessage(this,getString(R.string.error_date))
            }
        }
    }


    // create an OnDateSetListener
    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }


    private fun updateDateInView() {
        val myFormat = "yyyy-MM-dd" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        flightdate!!.text = sdf.format(cal.time)
    }

    /**
     * Observer for Flight status details.
     */
    private fun initObservers() {
        mAndroidViewModel?.getFlightData()?.observe(this, Observer {
            progress_circular.visibility = View.GONE
            sendData(it)
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
