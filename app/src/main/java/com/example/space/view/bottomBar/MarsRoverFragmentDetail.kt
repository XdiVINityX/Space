package com.example.space.view.bottomBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.databinding.FragmentMarsRoverDetailBinding
import com.example.space.view.RoverSolAdapter


class MarsRoverFragmentDetail : Fragment() {

    private var _binding: FragmentMarsRoverDetailBinding? = null
    private val binding get() = _binding!!
    private val adapter = RoverSolAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsRoverDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerSol.adapter = adapter


    }

    companion object {
        fun newInstance() = MarsRoverFragmentDetail
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}