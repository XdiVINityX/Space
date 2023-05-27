package com.example.space.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.space.R
import com.example.space.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
       // WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container,PictureOfTheDayFragment.newInstance())
                .commit()

        }

    }


}