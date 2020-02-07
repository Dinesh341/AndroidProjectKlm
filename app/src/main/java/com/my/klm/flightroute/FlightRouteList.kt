package com.my.klm.flightroute

import FlightStatusData
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.FlightRouteListAdapter
import com.klm.ViewModels.FlightViewModel
import com.my.klm.FlightDetailView
import com.my.klm.FlightStatusActivity
import com.my.klm.R
import com.my.klm.model.route.FlightRouteBase
import com.my.klm.model.route.OperationalFlights

import kotlinx.android.synthetic.main.flightroutelist.*


class FlightRouteList : AppCompatActivity() {
    private var mAndroidViewModel: FlightViewModel? = null

    companion object {
        fun startActivity(context: Context, flightRouteBase: OperationalFlights) {
            val intent = Intent(context, FlightDetailView::class.java)
            intent.putExtra("flightRouteData", flightRouteBase)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flightroutelist)
        mAndroidViewModel =
            ViewModelProviders.of(this@FlightRouteList).get(FlightViewModel::class.java)
        val flightRouteData = intent.getParcelableExtra<FlightRouteBase>(getString(R.string.flightroutedata))
        flightRouteData.operationalFlights?.let { setAdapter(it) }
    }

    private fun setAdapter(operationalFlights : List<OperationalFlights>) {
        val adapter = FlightRouteListAdapter(this, operationalFlights)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView.adapter = adapter
    }

}
