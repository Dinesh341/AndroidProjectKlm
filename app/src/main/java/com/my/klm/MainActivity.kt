package com.my.klm

import TokenData
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.klm.ViewModels.FlightViewModel
import com.my.klm.Utils.PrefUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flight_status.setOnClickListener {
            intent = Intent(this, FlightStatusActivity::class.java)
            startActivity(intent)
        }
        flight_route.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                getString(R.string.under_dev),
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
        mAndroidViewModel =
            ViewModelProviders.of(this@MainActivity).get(FlightViewModel::class.java)
        initTokenObservers()
        mAndroidViewModel?.getToken()
    }


    private fun initTokenObservers() {
        mAndroidViewModel?.getTokenValue()?.observe(this, Observer {
            it?.let {
                getToken(it)
            }
        })
    }

    private fun getToken(it: TokenData) {
        PrefUtils.setStringPreference(this, getString(R.string.token), it.access_token)
    }

}
