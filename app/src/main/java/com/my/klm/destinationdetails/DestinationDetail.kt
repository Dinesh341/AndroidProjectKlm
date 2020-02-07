package com.my.klm.destinationdetails

import DestinationDetatilBase
import DestinationRouteBase
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.klm.ViewModels.FlightViewModel
import com.my.klm.R
import com.my.klm.Utils.PrefUtils
import kotlinx.android.synthetic.main.destinationdetatil.*
import kotlinx.android.synthetic.main.destinationroute.*
import kotlinx.android.synthetic.main.destinationroute.search_destination
import kotlinx.android.synthetic.main.flightroute.progress_bar
import java.util.*


class DestinationDetail : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null
    private var isStartDate: Boolean = false
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationdetatil)
        setTitle(R.string.weather_information)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mAndroidViewModel =
            ViewModelProviders.of(this@DestinationDetail).get(FlightViewModel::class.java)
        detaildestination.setOnClickListener {
            if (PrefUtils.isNetworkAvailable(this)) {
                searchDestinationDetails()
            } else {
                showErrorMessage(getString(R.string.internet_check))
            }
        }
        initObservers()
    }

    /**
     * Get the Flight details based on the flight number and Date
     */
    private fun searchDestinationDetails() {
        var tokenValue = PrefUtils.getStringPreference(this, getString(R.string.token))
        tokenValue = "Bearer " + tokenValue
        var origin = origin.text.toString()
        if (!origin.isEmpty()) {

                progress_bar.visibility = View.VISIBLE
                mAndroidViewModel?.getDestinationDetailData(
                    progress_bar,origin.toUpperCase(),
                    tokenValue.toString()
                )

            } else {
                    showErrorMessage(getString(R.string.error_origin))
            }

    }


        /**
         * Show the Error Message
         */
        private fun showErrorMessage(errorMessage: String) {
            val toast = Toast.makeText(
                applicationContext,
                errorMessage,
                Toast.LENGTH_SHORT
            )
            toast.show()
        }


        /**
         * Observer for Flight status details.
         */
        private fun initObservers() {
            mAndroidViewModel?.getDestinationDetatilData()?.observe(this, Observer {
                it?.let {
                    progress_bar.visibility = View.GONE
                    sendData(it)
                }
            })
        }

        /**
         * Share the Flight data into Flight detail view
         */
        private fun sendData(destinationBase: DestinationDetatilBase) {
            val intent = Intent(this, DestinationDetailView::class.java)
            intent.putExtra(getString(R.string.destinationdetaildata), destinationBase)
            startActivity(intent)
        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }
