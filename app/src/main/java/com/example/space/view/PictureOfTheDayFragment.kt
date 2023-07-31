package com.example.space.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.space.R
import com.example.space.databinding.FragmentDailyPictureBinding
import com.example.space.view.bottomBar.mars.main.MainMarsRoversFragment
import com.example.space.view.bottomBar.settings.SettingsFragment
import com.example.space.viewmodel.appState.AppStatePictureOfTheDay
import com.example.space.viewmodel.PictureOfTheDayEnum
import com.example.space.viewmodel.PictureOfTheDayViewModel


class PictureOfTheDayFragment : Fragment() {

    companion object {
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
    ): View {
        _binding = FragmentDailyPictureBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner) { appState ->
            renderData(appState)
        }
        viewModel.sentRequest(PictureOfTheDayEnum.TODAY)
        cheapOnClickRequest()
        bottomNavigationViewOnClick()

    }


    private fun bottomNavigationViewOnClick(){
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.action_settings ->{
                    navigateTo(SettingsFragment());true
                }
                R.id.action_view_mars ->{
                    navigateTo(MainMarsRoversFragment());true
                }
               else -> true

            }
        }
    }
    private fun navigateTo(fragment: Fragment){
        requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment)
            .addToBackStack("")
            .commit()
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

    }

    private fun renderData(appState: AppStatePictureOfTheDay) {
        when (appState) {
            AppStatePictureOfTheDay.Loading -> {
                Toast.makeText(context, "Загрузка...", Toast.LENGTH_LONG).show()
            }

            is AppStatePictureOfTheDay.Success -> {
                val url = appState.pictureOfTheDayResponseData.url
                binding.imageView.load(url)
                Toast.makeText(context, url, Toast.LENGTH_LONG).show()
            }


            is AppStatePictureOfTheDay.Error -> {
                //TODO()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}