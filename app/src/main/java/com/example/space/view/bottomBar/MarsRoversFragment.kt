package com.example.space.view.bottomBar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.R
import com.example.space.databinding.FragmentMarsRoversBinding

class MarsRoversFragment : Fragment() {

    private var _binding: FragmentMarsRoversBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MarsRoversViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsRoversBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarsRoversViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.roverPerseverance.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .add(R.id.container, MarsRoverFragmentDetail())
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

}