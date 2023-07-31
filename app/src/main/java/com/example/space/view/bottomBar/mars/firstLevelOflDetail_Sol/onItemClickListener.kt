package com.example.space.view.bottomBar.mars.firstLevelOflDetail_Sol

import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData

interface OnItemViewClickListener {
   fun onItemClickNewInstanceDetail(photo: ManifestRoverResponseData.PhotoManifest.Photo)
}