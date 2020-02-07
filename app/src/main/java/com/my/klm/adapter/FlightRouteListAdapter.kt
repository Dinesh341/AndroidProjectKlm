package com.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.klm.R
import com.my.klm.flightroute.FlightRouteList
import com.my.klm.model.route.OperationalFlights

class FlightRouteListAdapter(private val context: Context, private val routeList: List<OperationalFlights>) :

    RecyclerView.Adapter<FlightRouteListAdapter.MovieViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val movieListItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.route_items_row, parent, false)
            return MovieViewHolder(movieListItem)
        }

        override fun getItemCount() = routeList.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val routeData = routeList[position]
            val sourceDestination= routeData.flightLegs?.get(0)?.departureInformation?.airport?.city?.name+" - "+
                    routeData.flightLegs?.get(0)?.arrivalInformation?.airport?.city?.name
            holder.routeTitle.text = sourceDestination
            holder.routeTime.text =   routeData.flightLegs?.get(0)?.departureInformation?.times?.scheduled+" - "+
                    routeData.flightLegs?.get(0)?.arrivalInformation?.times?.scheduled
            holder.routeDate.text = routeData.flightScheduleDate
            holder.flightNumber.text = "KL"+routeData.flightNumber.toString()
            holder.flightStatus.text = routeData.flightStatusPublic
            holder.itemView.setOnClickListener {
                FlightRouteList.startActivity(context, routeData)
            }
        }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val routeTitle: TextView = itemView.findViewById(R.id.route_title)
        val routeTime: TextView = itemView.findViewById(R.id.route_time)
        val routeDate: TextView = itemView.findViewById(R.id.route_date)
        val flightNumber: TextView = itemView.findViewById(R.id.fligh_no)
        val flightStatus: TextView = itemView.findViewById(R.id.flight_status)
    }

}