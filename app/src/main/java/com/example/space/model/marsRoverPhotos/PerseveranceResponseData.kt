package com.example.space.model.marsRoverPhotos


data class Perseverance(
    val photo_manifest: PhotoManifest
)

data class PhotoManifest(
    val landing_date: String,
    val launch_date: String,
    val max_date: String,
    val max_sol: Int,
    val name: String,
    val photos: List<Photo>,
    val status: String,
    val total_photos: Int
)

data class Photo(
    val cameras: List<String>,
    val earth_date: String,
    val sol: Int,
    val total_photos: Int
)