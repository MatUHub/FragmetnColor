package com.example.fragmetncolor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmetncolor.databinding.ActivityMainBinding
import com.example.fragmetncolor.domain.ColorEntity
import com.example.fragmetncolor.ui.colorslist.ColorListFragment
import com.example.fragmetncolor.ui.colorview.ColorViewerFragment

class MainActivity : AppCompatActivity(), ColorListFragment.Controller {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val masterFragment: Fragment = ColorListFragment()

        supportFragmentManager
            .beginTransaction()
            .add(binding.mainFragmentColor.id, masterFragment)
            .commit()
    }

    override fun openColorScreen(color: ColorEntity) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(
                binding.detailFragmentColor.id,
                ColorViewerFragment.newInstance(color)
            )
            .commit()
    }
}