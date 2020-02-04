package com.my.klm

import FlightStatusData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.klm.ViewModels.FlightViewModel
import kotlinx.android.synthetic.main.flightstatus.*

class FlightDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flightstatus)
        val productData = intent.getParcelableExtra<FlightStatusData>(getString(R.string.flightdata))
        arrival_date_value.setText(productData.flightScheduleDate)
        flightno.setText(getString(R.string.status_flight)+productData.flightNumber)
        arrival_time_value.setText("--")
        flighttime.setText(productData.flightStatusPublic)
        operated.setText(productData.flightLegs?.get(0)?.aircraft?.typeName)
        from_to.setText(productData.flightLegs?.get(0)?.departureInformation?.airport?.city?.name+" - "+ productData.flightLegs?.get(0)?.arrivalInformation?.airport?.city?.name)
    }
}
