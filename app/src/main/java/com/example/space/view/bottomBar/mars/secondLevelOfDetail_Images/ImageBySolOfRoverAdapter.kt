package com.example.space.view.bottomBar.mars.secondLevelOfDetail_Images

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.space.R
import com.example.space.model.marsRoverPhotos.photos.Photo
import com.example.space.model.marsRoverPhotos.photos.PhotosOfSolByRoverResponseData

class ImageBySolOfRoverAdapter : Adapter<ImageBySolOfRoverAdapter.ImageHolder>() {

    private lateinit var photoList : List<Photo>
    private lateinit var listener: OnPhotoViewClickListener

    fun setImageList(data : PhotosOfSolByRoverResponseData){
        photoList = data.photos
    }

    fun setListener(fragmentMarsImage: OnPhotoViewClickListener){
        listener = fragmentMarsImage
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_mars_images_item,parent,false)
            )
    }


    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.render(photoList[position])

    }

    inner class ImageHolder(itemView: View) : ViewHolder(itemView) {
        fun render(photo: Photo){
            itemView.findViewById<ImageView>(R.id.ImageViewOfSolByRover).load(photo.img_src)
            itemView.findViewById<TextView>(R.id.solOfPhoto).text = "Sol: ${photo.sol.toString()}"
            itemView.findViewById<TextView>(R.id.dataOfPhoto).text ="Data: ${photo.earth_date.toString()}"
            itemView.findViewById<TextView>(R.id.roverName).text = photo.rover.name

            itemView.findViewById<ImageView>(R.id.ImageViewOfSolByRover).setOnClickListener{
                listener.onPhotoClickListener(photo)

            }
        }

    }


    override fun getItemCount(): Int {
       return photoList.size
    }
}