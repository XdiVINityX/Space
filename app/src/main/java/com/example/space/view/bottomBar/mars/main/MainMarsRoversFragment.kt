package com.example.space.view.bottomBar.mars.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.R
import com.example.space.databinding.FragmentMainMarsRoversBinding
import com.example.space.utils.enumRovers.RoversEnum
import com.example.space.view.bottomBar.mars.firstLevelOflDetail_Sol.MarsSolOfRoverFragment
import com.example.space.viewmodel.MarsRoversViewModel
import com.example.space.viewmodel.appState.AppStateRovers
import kotlin.concurrent.thread

class MainMarsRoversFragment : Fragment() {

    private var _binding: FragmentMainMarsRoversBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MarsRoversViewModel by lazy {
        ViewModelProvider(this).get(MarsRoversViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainMarsRoversBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveDataPerseverance().observe(viewLifecycleOwner) {
            renderData(it, RoversEnum.PERSEVERANCE)
        }
        viewModel.getLiveDataCuriosity().observe(viewLifecycleOwner) {
            renderData(it, RoversEnum.CURIOSITY)
        }
        viewModel.getLiveDataOpportunity().observe(viewLifecycleOwner) {
            renderData(it, RoversEnum.OPPORTUNITY)
        }
        viewModel.getLiveDataSpirit().observe(viewLifecycleOwner) {
            renderData(it, RoversEnum.SPIRIT)
        }
        sendRequestRovers()


        binding.roverPerseverance.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .add(R.id.container, MarsSolOfRoverFragment())
                .commit()
        }
    }

    private fun sendRequestRovers() {
        thread { viewModel.sendRequestRoverPerseverance() }
        thread { viewModel.sendRequestRoverCuriosity() }
        thread { viewModel.sendRequestRoverOpportunity() }
        thread { viewModel.sendRequestRoverSpirit() }

    }


    companion object {
        fun newInstance() = MainMarsRoversFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun renderData(appState: AppStateRovers, rover: RoversEnum) {
        when (appState) {
            is AppStateRovers.Success -> {
                val maxSol = appState.roverResponseData.rover.max_sol.toString()
                val maxDate = appState.roverResponseData.rover.max_date
                when (rover) {
                    RoversEnum.PERSEVERANCE -> {
                        binding.maxSolPerseverance.append(maxSol)
                        binding.maxDatePerseverance.append(maxDate)
                    }

                    RoversEnum.CURIOSITY -> {
                        binding.maxSolCuriosity.append(maxSol)
                        binding.maxDateCuriosity.append(maxDate)
                    }

                    RoversEnum.OPPORTUNITY -> {
                        binding.maxSolOpportunity.append(maxSol)
                        binding.maxDateOpportunity.append(maxDate)
                    }

                    RoversEnum.SPIRIT -> {
                        binding.maxSolSpirit.append(maxSol)
                        binding.maxDateSpirit.append(maxDate)
                    }
                }
            }

            is AppStateRovers.Error -> TODO()
            AppStateRovers.Loading -> TODO()

        }

    }


}