package com.example.space.view.bottomBar.mars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.space.R
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData

class RoverSolAdapter : RecyclerView.Adapter<RoverSolAdapter.RoverSolHolder>() {

    private lateinit var manifestRoverData:ManifestRoverResponseData

   // private var solList = (1..1000).toList()

    fun setManifestData(value : ManifestRoverResponseData )  {
       manifestRoverData = value
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoverSolHolder {
        return RoverSolHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_sol_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RoverSolHolder, position: Int) {
        holder.render(manifestRoverData.photoManifest.photos[position])
    }

    inner class RoverSolHolder(itemView: View) : ViewHolder(itemView) {
        fun render(photoElement: ManifestRoverResponseData.PhotoManifest.Photo) {
            itemView.findViewById<TextView>(R.id.roverSol).text = "Sol: ${(photoElement.sol.toString())} "
            itemView.findViewById<TextView>(R.id.roverDateOfMission).text = "Date: ${(photoElement.earthDate.toString())} "
            itemView.findViewById<TextView>(R.id.roverNumbersOfPhoto).text = "Numbers of photo: ${(photoElement.totalPhotos.toString())} "

        }
    }

    override fun getItemCount(): Int {
        return manifestRoverData.photoManifest.photos.size
    }


}