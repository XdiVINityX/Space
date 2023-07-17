package com.example.space.view.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.databinding.FragmentViewPagerPictureOfTheDayBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ViewPagerPictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentViewPagerPictureOfTheDayBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentViewPagerPictureOfTheDayBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter = ViewPager2Adapter(requireActivity())
        TabLayoutMediator(binding.tabLayout,binding.viewPager2,object: TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = when(position){
                    0 -> {
                        "Земля"
                    }
                    1 -> {
                        "Марс"
                    }
                    2 -> {
                        "Система"
                    }
                    else -> {
                        "Ошибка"
                    }
                }
            }
        }).attach()
    }

    companion object {
        fun newInstance() = ViewPagerPictureOfTheDayFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}