package com.example.space.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = arrayOf(EarthFragment(),MarsFragment(),SystemFragment())

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}