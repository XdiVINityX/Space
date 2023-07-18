package com.example.space.view.bottomBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import com.example.space.R
import com.example.space.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.lightTheme.setOnClickListener{
            val themeName = R.style.Base_Theme_SpaceLight
            val sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(requireContext())
                .edit()
                .putInt("themeKey",themeName)
                .apply()
            requireActivity().recreate()



        }
        binding.darkTheme.setOnClickListener {
            val themeName = R.style.Base_Theme_SpaceDark
            val sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(requireContext())
                .edit()
                .putInt("themeKey",themeName)
                .apply()
            requireActivity().recreate()

        }
        binding.anotherTheme.setOnClickListener {

        }
    }


    companion object {
        fun newInstance() = SettingsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}