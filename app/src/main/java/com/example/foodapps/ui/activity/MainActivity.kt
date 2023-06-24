package com.example.foodapps.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapps.R
import com.example.foodapps.ui.fragment.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}