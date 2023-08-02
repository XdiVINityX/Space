package com.example.space.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.preference.PreferenceManager
import com.example.space.R
import com.example.space.databinding.ActivityMainBinding
import com.example.space.view.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var statusBar : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        setThemeFromPreferences()


        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commit()

        }

    }

    private fun setThemeFromPreferences() {
        val defaultTheme = R.style.Base_Theme_SpaceLight
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val themeName  = sharedPreferences.getInt("themeKey",defaultTheme)
        setTheme(themeName)

    }


    override fun onSupportNavigateUp(): Boolean {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat
                .BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        return super.onSupportNavigateUp()

        }

    }


}