package com.my.klm.destinationdetails

import DestinationDetatilBase
import FlightStatusData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.klm.R
import com.my.klm.model.route.OperationalFlights
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.destinationdetailview.*
import kotlinx.android.synthetic.main.flightstatus.*

class DestinationDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationdetailview)
        setTitle(R.string.destination_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val destinationDetailData =
            intent.getParcelableExtra<DestinationDetatilBase>(getString(R.string.destinationdetaildata))
        destinationDetailData?.let {
            weather_label.setText(destinationDetailData.weather.data.description.label)
            weather_description.setText(destinationDetailData.weather.data.description.description)
            temp_value.setText(
                destinationDetailData.weather.data?.temperature[0]?.value.toString() + getString(
                    R.string.degree_symbol
                ) + " " + destinationDetailData.weather.data?.temperature[0]?.unit.toString()
            )
            currency_value.setText(destinationDetailData.currency.data.label)
            spoken_lang_values.setText(destinationDetailData?.spokenLanguages[0]?.label)
            var url = destinationDetailData.weather.data.description.pictoUrl
            url?.let {
                Picasso.get().load(url.toString())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background).into(weatherimg)
            }
            orgincitycode.setText(destinationDetailData.originCity.code)
            orgincitylabel.setText(destinationDetailData.originCity.label)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
