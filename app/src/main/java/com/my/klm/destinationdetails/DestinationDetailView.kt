package com.my.klm.destinationdetails

import com.my.klm.model.destinationdetail.DestinationDetatilBase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.my.klm.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.destinationdetailview.*

class DestinationDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationdetailview)
        setTitle(R.string.destination_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val destinationDetailData =
            intent.getParcelableExtra<DestinationDetatilBase>(getString(R.string.destinationdetaildata))
        destinationDetailData?.let {
            weather_label.text = destinationDetailData.weather.data.description.label
            weather_description.text = destinationDetailData.weather.data.description.description
            temp_value.text = destinationDetailData.weather.data.temperature[0].value.toString() + getString(
                R.string.degree_symbol
            ) + " " + destinationDetailData.weather.data.temperature[0].unit
            currency_value.text = destinationDetailData.currency.data.label
            spoken_lang_values.text = destinationDetailData.spokenLanguages[0].label
            val url = destinationDetailData.weather.data.description.pictoUrl
            url.let {
                Picasso.get().load(url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background).into(weatherimg)
            }
            orgincitycode.text = destinationDetailData.originCity.code
            orgincitylabel.text = destinationDetailData.originCity.label
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
