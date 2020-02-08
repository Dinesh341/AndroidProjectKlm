package com.my.klm.destinationroute

import com.my.klm.model.destination.DestinationRouteBase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.klm.adapter.DestinationRouteListAdapter
import com.my.klm.R
import kotlinx.android.synthetic.main.flightroutelist.*


class DestinationRouteList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destinationroutelist)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setTitle(R.string.destination_suggestions)
        val flightRouteData =
            intent.getParcelableExtra<DestinationRouteBase>(getString(R.string.destinationroutedata))
        flightRouteData?.let { setAdapter(it) }
    }

    private fun setAdapter(operationalFlights: DestinationRouteBase) {
        val adapter = DestinationRouteListAdapter( operationalFlights)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
