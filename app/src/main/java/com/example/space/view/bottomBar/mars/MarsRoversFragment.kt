package com.example.space.view.bottomBar.mars

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.R
import com.example.space.databinding.FragmentMarsRoversBinding
import com.example.space.viewmodel.MarsRoversViewModel
import com.example.space.viewmodel.appState.AppStateRovers

class MarsRoversFragment : Fragment() {

    private var _binding: FragmentMarsRoversBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MarsRoversViewModel by lazy {
        ViewModelProvider(this).get(MarsRoversViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsRoversBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveData().observe(viewLifecycleOwner){
            renderDate(it)
        }
        viewModel.sendRequestRoverPerseverance()


        binding.roverPerseverance.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .add(R.id.container, MarsSolOfRoverFragment())
                .commit()
        }
    }

    companion object {
        fun newInstance() = MarsRoversFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderDate( appState: AppStateRovers){
        when(appState){
            is AppStateRovers.Success -> {
                binding.maxSolPerseverance.append(appState.perseveranceResponseData.rover.max_sol.toString())
                binding.maxDatePerseverance.append(appState.perseveranceResponseData.rover.max_date).toString()
                Log.d("Mytag", "renderDate: $appState.perseveranceResponseData ")
            }
            is AppStateRovers.Error -> {
                TODO()
            }
            AppStateRovers.Loading -> {
                TODO()
            }

            else -> {}
        }

    }

}