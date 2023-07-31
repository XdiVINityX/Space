package com.example.space.view.bottomBar.mars.secondLevelOfDetail_Images

import android.net.Uri
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
import com.github.chrisbanes.photoview.PhotoView

class ImageBySolOfRoverAdapter : Adapter<ImageBySolOfRoverAdapter.ImageHolder>() {

    private lateinit var photoList : List<Photo>

    fun setImageList(data : PhotosOfSolByRoverResponseData){
        photoList = data.photos
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_mars_images_item,parent,false)
            )

    }



    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.render(photoList[position])

            // val photoView = holder.itemView.findViewById<PhotoView>(R.id.photo_view)
        //val imageUrl = "https://example.com/image.jpg"

    }

    inner class ImageHolder(itemView: View) : ViewHolder(itemView) {
        fun render(photo: Photo){

            itemView.findViewById<PhotoView>(R.id.photoViewOfSolByRover).load(photo.img_src)
            itemView.findViewById<TextView>(R.id.solOfPhoto).text = photo.sol.toString()
            itemView.findViewById<TextView>(R.id.dataOfPhoto).text = photo.earth_date.toString()
        }

    }


    override fun getItemCount(): Int {
       return photoList.size
    }
}