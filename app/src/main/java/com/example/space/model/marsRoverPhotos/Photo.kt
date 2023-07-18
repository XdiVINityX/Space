package com.example.space.model.marsRoverPhotos

data class Photo(
    val cameras: List<String>,
    val earth_date: String,
    val sol: Int,
    val total_photos: Int
)