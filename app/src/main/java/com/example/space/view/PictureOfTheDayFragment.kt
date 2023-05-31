package com.example.space.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.space.databinding.FragmentDailyPictureBinding
import com.example.space.viewmodel.AppState
import com.example.space.viewmodel.PictureOfTheDayEnum
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
        viewModel.sentRequest(PictureOfTheDayEnum.TODAY)
        cheapOnClickRequest()
    }

    private fun cheapOnClickRequest() {

        binding.chipToday.setOnClickListener {
            viewModel.sentRequest(PictureOfTheDayEnum.TODAY)
            Toast.makeText(context, "Изображение согодняшнего дня!", Toast.LENGTH_SHORT).show()
        }
        binding.chipYesterday.setOnClickListener {
            viewModel.sentRequest(PictureOfTheDayEnum.YESTERDAY)
            //Toast.makeText(context, "Вчерашнее изображение!", Toast.LENGTH_SHORT).show()
        }
        binding.chipDayBeforeYesterday.setOnClickListener {
            viewModel.sentRequest(PictureOfTheDayEnum.DAY_BEFORE_YESTERDAY)
        }

        binding.textInput.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://ru.wikipedia.org/wiki")
            })
        }
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            AppState.Loading ->{
                Toast.makeText(context, "Загрузка...", Toast.LENGTH_LONG).show()
            }
            is AppState.Success -> {
                val url = appState.pictureOfTheDayResponseData.url
                binding.imageView.load(url)
                Toast.makeText(context, url, Toast.LENGTH_LONG).show()
            }


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