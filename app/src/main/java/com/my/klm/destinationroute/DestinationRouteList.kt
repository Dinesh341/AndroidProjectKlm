package com.my.klm.destinationroute

import DestinationRouteBase
import FlightStatusData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.DestinationRouteListAdapter
import com.adapter.FlightRouteListAdapter
import com.klm.ViewModels.FlightViewModel
import com.my.klm.FlightDetailView
import com.my.klm.FlightStatusActivity
import com.my.klm.R
import com.my.klm.model.route.FlightRouteBase
import com.my.klm.model.route.OperationalFlights

import kotlinx.android.synthetic.main.flightroutelist.*


class DestinationRouteList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationroutelist)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setTitle(R.string.destination_suggestions)
        val flightRouteData =
            intent.getParcelableExtra<DestinationRouteBase>(getString(R.string.destinationroutedata))
        flightRouteData?.let { setAdapter(it) }
    }

    private fun setAdapter(operationalFlights: DestinationRouteBase) {
        val adapter = DestinationRouteListAdapter(this, operationalFlights)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
