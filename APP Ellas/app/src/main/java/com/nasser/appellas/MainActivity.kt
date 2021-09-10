package com.nasser.appellas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavHost
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nasser.appellas.databinding.ActivityMainBinding
import com.nasser.appellas.ui.AppViewModel
import com.nasser.appellas.ui.AppViewModelFactory

class MainActivity : AppCompatActivity() {

    private val userApp by lazy {
        application as AppApplication
    }

    private val appViewModel: AppViewModel by viewModels {
        AppViewModelFactory(userApp.appRepository)
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewmodel = appViewModel
            lifecycleOwner = this@MainActivity
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_fragment) as NavHost

        val navController = navHostFragment.navController

        appViewModel.actual.observe(this){
            appViewModel.actual.observe(this){
                navController.navigate(appViewModel.getActual())
            }
        }
    }

}