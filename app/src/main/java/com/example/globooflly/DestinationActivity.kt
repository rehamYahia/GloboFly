package com.example.globooflly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.globooflly.databinding.ActivityDestinationBinding


class DestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDestinationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navControler = navHost.navController

    }
}