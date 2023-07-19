package com.example.space.model.marsRoverPhotos
import com.google.gson.annotations.SerializedName


data class Perseverance(
    @SerializedName("photo_manifest")
    val photoManifest: PhotoManifest
) {
    data class PhotoManifest(
        val name: String,
        @SerializedName("landing_date")
        val landingDate: String,
        @SerializedName("launch_date")
        val launchDate: String,
        val status: String,
        @SerializedName("max_sol")
        val maxSol: Int,
        @SerializedName("max_date")
        val maxDate: String,
        @SerializedName("total_photos")
        val totalPhotos: Int,
        val photos: List<Photo>
    ) {
        data class Photo(
            val sol: Int,
            @SerializedName("earth_date")
            val earthDate: String,
            @SerializedName("total_photos")
            val totalPhotos: Int,
            val cameras: List<String>
        )
    }
}
