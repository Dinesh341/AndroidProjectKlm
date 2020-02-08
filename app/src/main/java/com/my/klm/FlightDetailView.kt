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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val flightData = intent.getParcelableExtra<FlightStatusData>(getString(R.string.flightdata))
        val flightRouteData =
            intent.getParcelableExtra<OperationalFlights>(getString(R.string.flight_route_data))
        flightRouteData?.let {
            arrival_date_value.text = flightRouteData.flightScheduleDate
            flightno.text = getString(R.string.status_flight, flightRouteData.flightNumber)
            getString(R.string.status_flight, flightRouteData.flightNumber)
            arrival_time_value.text = getString(
                R.string.arrival_time,
                flightRouteData.flightLegs?.get(0)?.departureInformation?.times?.scheduled,
                flightRouteData.flightLegs?.get(0)?.arrivalInformation?.times?.scheduled
            )
            flighttime.text = flightRouteData.flightStatusPublic
            operated.text = flightRouteData.flightLegs?.get(0)?.aircraft?.typeName
            from_to.text = getString(
                R.string.from_to,
                flightRouteData.flightLegs?.get(0)?.departureInformation?.airport?.city?.name,
                flightRouteData.flightLegs?.get(0)?.arrivalInformation?.airport?.city?.name
            )
        }
        flightData?.let {
            arrival_date_value.text = flightData.flightScheduleDate
            flightno.text = getString(R.string.status_flight, flightData.flightNumber)
            arrival_time_value.text = getString(
                R.string.arrival_time,
                flightData.flightLegs?.get(0)?.departureInformation?.times?.scheduled,
                flightData.flightLegs?.get(0)?.arrivalInformation?.times?.scheduled
            )
            operated.text = flightData.flightLegs?.get(0)?.aircraft?.typeName
            from_to.text = getString(
                R.string.from_to,
                flightData.flightLegs?.get(0)?.departureInformation?.airport?.city?.name,
                flightData.flightLegs?.get(0)?.arrivalInformation?.airport?.city?.name
            )
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
