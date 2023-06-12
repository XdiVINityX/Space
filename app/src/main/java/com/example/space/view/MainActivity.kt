package com.example.space.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.space.R
import com.example.space.databinding.ActivityMainBinding
import com.example.space.view.viewpager.ViewPagerPictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setThemeFromPreferences()

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ViewPagerPictureOfTheDayFragment.newInstance())
                .commit()



        /*if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commit()

        }*/

    }

    private fun setThemeFromPreferences() {
        val defaultTheme = R.style.Base_Theme_Space
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val themeName  = sharedPreferences.getInt("themeKey",defaultTheme)
        setTheme(themeName)

    }


}