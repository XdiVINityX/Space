package com.example.space.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.space.databinding.FragmentDailyPictureBinding
import com.example.space.viewmodel.AppState
import com.example.space.viewmodel.PictureOfTheDayViewModel


class PictureOfTheDayFragment : Fragment() {

    companion object{
        fun newInstance() = PictureOfTheDayFragment()
    }

    private var _binding: FragmentDailyPictureBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDailyPictureBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner) {appState ->
            renderData(appState)
        }
        viewModel.sentRequest()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            AppState.Loading ->{
                //TODO()
            }
            is AppState.Success ->
                binding.imageView.load(appState.pictureOfTheDayResponseData.url)

            is AppState.Error ->{
                //TODO()
            }

            else -> {}
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}