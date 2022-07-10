package com.example.githubtestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubtestapp.R
import com.example.githubtestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, AuthFragment())
            .commit()
    }
}