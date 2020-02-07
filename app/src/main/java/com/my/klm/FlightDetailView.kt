package com.my.klm

import com.my.klm.model.FlightStatusData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.klm.model.route.OperationalFlights
import kotlinx.android.synthetic.main.flightstatus.*

class FlightDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flightstatus)
        setTitle(R.string.flight_detail)
        supportActionBar.let {

        }
        val flightData = intent.getParcelableExtra<FlightStatusData>(getString(R.string.flightdata))
        val flightRouteData = intent.getParcelableExtra<OperationalFlights>(getString(R.string.flight_route_data))
        flightRouteData?.let {
            arrival_date_value.setText(flightRouteData.flightScheduleDate)
            flightno.setText(getString(R.string.status_flight)+flightRouteData.flightNumber)
            arrival_time_value.setText(flightRouteData.flightLegs?.get(0)?.departureInformation?.times?.scheduled+" - "+
                    flightRouteData.flightLegs?.get(0)?.arrivalInformation?.times?.scheduled)
            flighttime.setText(flightRouteData.flightStatusPublic)
            operated.setText(flightRouteData.flightLegs?.get(0)?.aircraft?.typeName)
            from_to.setText(flightRouteData.flightLegs?.get(0)?.departureInformation?.airport?.city?.name+" - "+ flightRouteData.flightLegs?.get(0)?.arrivalInformation?.airport?.city?.name)
        }
        flightData?.let {
            arrival_date_value.setText(flightData.flightScheduleDate)
            flightno.setText(getString(R.string.status_flight)+flightData.flightNumber)
            arrival_time_value.setText(flightData.flightLegs?.get(0)?.departureInformation?.times?.scheduled+" - "+
                    flightData.flightLegs?.get(0)?.arrivalInformation?.times?.scheduled)
            operated.setText(flightData.flightLegs?.get(0)?.aircraft?.typeName)
            from_to.setText(flightData.flightLegs?.get(0)?.departureInformation?.airport?.city?.name+" - "+ flightData.flightLegs?.get(0)?.arrivalInformation?.airport?.city?.name)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
