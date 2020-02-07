package com.adapter

import DestinationRouteBase
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.klm.R
import com.squareup.picasso.Picasso

class DestinationRouteListAdapter(private val context: Context, private val routeList: DestinationRouteBase) :

    RecyclerView.Adapter<DestinationRouteListAdapter.MovieViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val movieListItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.destination_items_row, parent, false)
            return MovieViewHolder(movieListItem)
        }

        override fun getItemCount() = routeList.airports.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            try {
                val routeData = routeList.airports[position]
                holder.routeLabel.text = routeData.airportLabel
                holder.routeTitle.text = routeList?.destinations[position]?.title
                holder.reginalLabel.text = routeList?.regions[position]?.regionLabel
                holder.countryLabel.text = routeList?.countries[position]?.countryLabel
                val url = routeList?.destinations[position]?.picture.imageUrl
                url?.let {
                    Picasso.get().load(url.toString())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background).into(holder.weatherImage)
                }
            }catch (ex:Exception){
                Log.e("Exception",ex.message)
            }
        }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weatherImage: ImageView = itemView.findViewById(R.id.weather_img)
        val routeTitle: TextView = itemView.findViewById(R.id.destination_title)
        val routeLabel: TextView = itemView.findViewById(R.id.label)
        val reginalLabel: TextView = itemView.findViewById(R.id.region_label)
        val countryLabel: TextView = itemView.findViewById(R.id.country_label)
    }


}