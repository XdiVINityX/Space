package com.example.space.view.bottomBar.mars.firstLevelOflDetail_Sol

import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.utils.enumRovers.RoversEnum

interface OnItemViewClickListener {
   fun onItemClickNewInstanceDetailImages(photo: ManifestRoverResponseData.PhotoManifest.Photo,rover: RoversEnum)
}