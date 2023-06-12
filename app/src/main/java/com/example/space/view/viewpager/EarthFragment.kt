package com.example.space.view.viewpager

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.R
import com.example.space.databinding.FragmentEarthBinding
import com.example.space.databinding.FragmentViewPagerPictureOfTheDayBinding
import com.example.space.viewmodel.EarthViewModel

class EarthFragment : Fragment() {

    private var _binding: FragmentEarthBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = EarthFragment()
    }

    private lateinit var viewModel: EarthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EarthViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}