package com.example.space.view.bottomBar.mars.firstLevelOflDetail_Sol

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.space.R
import com.example.space.databinding.FragmentMarsSolOfRoverBinding
import com.example.space.model.marsRoverPhotos.ManifestRoverResponseData
import com.example.space.utils.enumRovers.RoversEnum
import com.example.space.view.bottomBar.mars.secondLevelOfDetail_Images.MarsImagesFragment
import com.example.space.viewmodel.MarsSolOfRoverViewModel
import com.example.space.viewmodel.appState.AppStateManifestOfRover


class MarsSolOfRoverFragment : Fragment(), OnItemViewClickListener {

    private var _binding: FragmentMarsSolOfRoverBinding? = null
    private val binding get() = _binding!!
    private val adapter = RoverSolAdapter()

    private val viewModel: MarsSolOfRoverViewModel by lazy {
        ViewModelProvider(this).get(MarsSolOfRoverViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMarsSolOfRoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rover = RoversEnum.valueOf(arguments!!.getString(BUNDLE_KEY)!!)

        viewModel.getLiveData().observe(viewLifecycleOwner) {
            renderData(it)
        }
        viewModel.sendRequestManifestOfRover(rover)
    }

    private fun renderData(appStateManifestOfRover: AppStateManifestOfRover) {
        when (appStateManifestOfRover) {
            is AppStateManifestOfRover.Success -> {
                adapter.setManifestDataPhotosReversed(appStateManifestOfRover.responseData.photoManifest)
                binding.recyclerSol.adapter = adapter
                adapter.setClickOnInItemListener(this@MarsSolOfRoverFragment)
                //TODO()Установить значение адаптера в onViewCreated, но перед этим сделать выполнение   AppStateManifestOfRover.Loading.
                Log.d("MyTagMarsSolOfRoverFragment", "renderData $appStateManifestOfRover.perseveranceResponseData ")
            }

            is AppStateManifestOfRover.Error -> TODO()
            AppStateManifestOfRover.Loading -> TODO()

        }

    }

    companion object {
        const val BUNDLE_KEY = "key"
        fun newInstance(bundle: Bundle) : MarsSolOfRoverFragment  {
            val fragment = MarsSolOfRoverFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onItemClickNewInstanceDetail(photo: ManifestRoverResponseData.PhotoManifest.Photo) {
        val bundle = Bundle()
        bundle.putString(MarsImagesFragment.BUNDLE_KEY,photo.earthDate.toString())
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .addToBackStack("")
            .add(R.id.container, MarsImagesFragment.newInstance(bundle))
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}