package com.example.space.view.bottomBar.mars.secondLevelOfDetail_Images

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.R
import com.example.space.databinding.FragmentMarsImagesBinding
import com.example.space.model.marsRoverPhotos.photos.Photo
import com.example.space.model.marsRoverPhotos.photos.PhotosOfSolByRoverResponseData
import com.example.space.utils.enumRovers.RoversEnum
import com.example.space.view.bottomBar.mars.thirdLevel_PhotoView.PhotoViewContainerFragment
import com.example.space.viewmodel.MarsImagesViewModel
import com.example.space.viewmodel.appState.AppStatePhotosOfSolByRover

class MarsImagesFragment : Fragment(), OnPhotoViewClickListener{


    private var _binding : FragmentMarsImagesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MarsImagesViewModel by lazy {
       ViewModelProvider(this).get(MarsImagesViewModel::class.java)
    }
    private val adapter = ImageBySolOfRoverAdapter()

    private val earthData by lazy {
        arguments?.getString(BUNDLE_KEY_EARTH_DATA)?: "Пусто"
    }

    private val rover by lazy {
        RoversEnum.valueOf(arguments!!.getString(BUNDLE_KEY_ROVER)!!)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("myTag", "rover = $rover, earthData = $earthData")
        _binding = FragmentMarsImagesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getLiveData().observe(viewLifecycleOwner){
            render(it)
        }
        viewModel.sendRequestImagesByRover(earthData,rover)
        Log.d("myTag", "rover = $rover, earthData = $earthData")

    }

    private fun render(appStatePhotosOfSolByRover: AppStatePhotosOfSolByRover) {

        when(appStatePhotosOfSolByRover){

            is AppStatePhotosOfSolByRover.Success -> {
                adapter.setImageList(appStatePhotosOfSolByRover.photosOfSolByRoverResponseData)
                adapter.setListener(this@MarsImagesFragment)
                binding.recyclerPhotoOfSolByRover.adapter = adapter
            }
            is AppStatePhotosOfSolByRover.Error -> TODO()
            AppStatePhotosOfSolByRover.Loading -> TODO()

        }
    }


    override fun onPhotoClickListener(url: String) {
        val bundle = Bundle()
        bundle.putString(PhotoViewContainerFragment.BUNDLE_KEY,url)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack("")
            .add(R.id.container,PhotoViewContainerFragment.newInstance(bundle))
            .commit()
    }

    companion object {
        fun newInstance(bundle: Bundle): MarsImagesFragment {
            val fragment = MarsImagesFragment()
            fragment.arguments = bundle
            return fragment
        }
        const val BUNDLE_KEY_EARTH_DATA = "earthData"
        const val BUNDLE_KEY_ROVER = "rover"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }





}