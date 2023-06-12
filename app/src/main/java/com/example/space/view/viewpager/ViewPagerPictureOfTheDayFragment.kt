package com.example.space.view.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.space.databinding.FragmentViewPagerPictureOfTheDayBinding


class ViewPagerPictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentViewPagerPictureOfTheDayBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentViewPagerPictureOfTheDayBinding.inflate(inflater,container,false)
        binding.viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = ViewPagerAdapter(childFragmentManager)
    }

    companion object {
        fun newInstance() = ViewPagerPictureOfTheDayFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}