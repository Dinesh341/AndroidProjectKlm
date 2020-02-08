package com.my.klm.destinationdetails

import com.my.klm.model.destinationdetail.DestinationDetatilBase
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.my.klm.R
import com.my.klm.utils.PrefUtils
import com.my.klm.viewmodels.FlightViewModel
import kotlinx.android.synthetic.main.destinationdetatil.*
import kotlinx.android.synthetic.main.flightroute.progress_bar
import java.util.*


class DestinationDetail : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationdetatil)
        setTitle(R.string.weather_information)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mAndroidViewModel =
            ViewModelProviders.of(this@DestinationDetail).get(FlightViewModel::class.java)
        detaildestination.setOnClickListener {
            if (PrefUtils.isNetworkAvailable(this)) {
                searchDestinationDetails()
            } else {
                PrefUtils.showErrorMessage(this,getString(R.string.internet_check))
            }
        }
        initObservers()
    }

    /**
     * Get the Flight details based on the flight number and Date
     */
    private fun searchDestinationDetails() {
        var tokenValue = PrefUtils.getStringPreference(this, getString(R.string.token))
        tokenValue = getString(R.string.bearer_token, tokenValue)
        val origin = origin.text.toString()
        if (origin.isNotEmpty()) {
            progress_bar.visibility = View.VISIBLE
            mAndroidViewModel?.getDestinationDetailData(
                progress_bar, origin.toUpperCase(Locale.getDefault()),
                tokenValue.toString()
            )
        } else {
            PrefUtils.showErrorMessage(this,getString(R.string.error_origin))
        }
    }




    /**
     * Observer for Flight status details.
     */
    private fun initObservers() {
        mAndroidViewModel?.getDestinationDetatilData()?.observe(this, Observer {
            progress_bar.visibility = View.GONE
            sendData(it)
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
