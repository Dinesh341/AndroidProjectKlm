package com.my.klm.destinationroute

import com.my.klm.model.destination.DestinationRouteBase
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
import kotlinx.android.synthetic.main.destinationroute.*
import kotlinx.android.synthetic.main.flightroute.progress_bar


class DestinationRouteActivity : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationroute)
        setTitle(R.string.destination_suggestions)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mAndroidViewModel =
            ViewModelProviders.of(this@DestinationRouteActivity).get(FlightViewModel::class.java)
        search_destination.setOnClickListener {
            if (PrefUtils.isNetworkAvailable(this)) {
                destonationSuggestion()
            } else {
                showErrorMessage(getString(R.string.internet_check))
            }
        }
        initObservers()
    }

    /**
     * Get the Flight details based on the flight number and Date
     */
    private fun destonationSuggestion() {
        var tokenValue = PrefUtils.getStringPreference(this, getString(R.string.token))
        tokenValue = "Bearer " + tokenValue
        var cities = cities.text.toString()
        if (!cities.isEmpty()) {

                progress_bar.visibility = View.VISIBLE
                mAndroidViewModel?.getDestinationData(
                    progress_bar,cities.toUpperCase(),
                    tokenValue.toString()
                )

            } else {
                    showErrorMessage(getString(R.string.error_cities))
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
            mAndroidViewModel?.getDestinationData()?.observe(this, Observer {
                it?.let {
                    progress_bar.visibility = View.GONE
                    sendData(it)
                }
            })
        }

        /**
         * Share the Flight data into Flight detail view
         */
        private fun sendData(destinationBase: DestinationRouteBase) {
            val intent = Intent(this, DestinationRouteList::class.java)
            intent.putExtra(getString(R.string.destinationroutedata), destinationBase)
            startActivity(intent)
        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }
