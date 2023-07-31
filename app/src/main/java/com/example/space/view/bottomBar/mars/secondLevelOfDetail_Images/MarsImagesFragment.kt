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
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.viewmodel.MarsImagesViewModel
import com.example.space.viewmodel.appState.AppStatePhotosOfSolByRover

class MarsImagesFragment : Fragment() {


    private var _binding : FragmentMarsImagesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MarsImagesViewModel by lazy {
       ViewModelProvider(this).get(MarsImagesViewModel::class.java)
    }
    private val adapter = ImageBySolOfRoverAdapter()

    private val earthData : String  by lazy {
            arguments?.getString(BUNDLE_KEY)?: "Пусто"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsImagesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        viewModel.getLiveData().observe(viewLifecycleOwner){
            render(it)
        }
        viewModel.sendRequestImagesByRover(earthData)

    }

    private fun render(appStatePhotosOfSolByRover: AppStatePhotosOfSolByRover) {

        when(appStatePhotosOfSolByRover){

            is AppStatePhotosOfSolByRover.Success -> {
                adapter.setImageList(appStatePhotosOfSolByRover.photosOfSolByRoverResponseData)
                binding.recyclerPhotoOfSolByRover.adapter = adapter

            }

            is AppStatePhotosOfSolByRover.Error -> TODO()
            AppStatePhotosOfSolByRover.Loading -> TODO()

        }
    }

    companion object {
        fun newInstance(bundle: Bundle): MarsImagesFragment {
            val fragment = MarsImagesFragment()
            fragment.arguments = bundle
            return fragment
        }
        const val BUNDLE_KEY = "key"

    }

}