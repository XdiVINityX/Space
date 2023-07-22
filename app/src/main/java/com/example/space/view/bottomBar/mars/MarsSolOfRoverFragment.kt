package com.example.space.view.bottomBar.mars

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.space.databinding.FragmentMarsSolOfRoverBinding
import com.example.space.viewmodel.MarsSolOfRoverViewModel
import com.example.space.viewmodel.appState.AppStateManifestOfRover


class MarsSolOfRoverFragment : Fragment() {

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

        viewModel.getLiveData().observe(viewLifecycleOwner){
            renderData(it)
        }

        viewModel.sendRequestManifestRoverPerseverance()

        viewModel.getLiveData().observe(viewLifecycleOwner){

        }
    }

    private fun renderData(appStateManifestOfRover: AppStateManifestOfRover) {
        when (appStateManifestOfRover){
            is AppStateManifestOfRover.Success -> {
                adapter.setManifestData(appStateManifestOfRover.perseveranceResponseData)
                binding.recyclerSol.adapter = adapter
                Log.d("MyTag", "renderData $appStateManifestOfRover.perseveranceResponseData ")
            }
            is AppStateManifestOfRover.Error -> TODO()
            AppStateManifestOfRover.Loading -> TODO()

        }
    }

    companion object {
        fun newInstance() = MarsSolOfRoverFragment
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}