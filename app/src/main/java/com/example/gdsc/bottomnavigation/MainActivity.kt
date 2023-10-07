package com.example.gdsc.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gdsc.R
import com.example.gdsc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()

        with(binding) {
            navController?.let {
                navigationMain.setupWithNavController(it)
            }
        }
    }
}