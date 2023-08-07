package com.example.space.view.bottomBar.mars.firstLevelOflDetail_Sol


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.space.R
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.utils.enumRovers.RoversEnum

class RoverSolAdapter() : RecyclerView.Adapter<RoverSolAdapter.RoverSolHolder>() {

    private lateinit var manifestRoverDataPhotos : List<ManifestRoverResponseData.PhotoManifest.Photo>
    private lateinit var listener: OnItemViewClickListener
    private lateinit var rover: RoversEnum

    fun setManifestDataPhotosReversed(value : ManifestRoverResponseData.PhotoManifest) {
       manifestRoverDataPhotos = value.photos.reversed()
    }

    fun setClickOnInItemListener(fragmentMain : OnItemViewClickListener){
        listener = fragmentMain
    }
    fun setRover(roverArg: RoversEnum){
        rover = roverArg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoverSolHolder {
        return RoverSolHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_sol_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RoverSolHolder, position: Int) {

        holder.render(manifestRoverDataPhotos[position])
    }

    inner class RoverSolHolder(itemView: View) : ViewHolder(itemView) {

        fun render(photoElement: ManifestRoverResponseData.PhotoManifest.Photo) {
            itemView.findViewById<TextView>(R.id.roverSol).text = "Sol: ${(photoElement.sol.toString())} "
            itemView.findViewById<TextView>(R.id.roverDateOfMission).text = "Date: ${(photoElement.earthDate.toString())} "
            itemView.findViewById<TextView>(R.id.roverNumbersOfPhoto).text = "Numbers of photo: ${(photoElement.totalPhotos.toString())} "
            itemView.setOnClickListener(){
                listener.onItemClickNewInstanceDetailImages(photoElement, rover)
            }

        }

    }

    override fun getItemCount(): Int {
        return manifestRoverDataPhotos.size
    }


}