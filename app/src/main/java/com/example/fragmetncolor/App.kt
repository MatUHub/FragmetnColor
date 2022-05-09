package com.example.fragmetncolor

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.fragmetncolor.data.InMemoryColorRepoImpl
import com.example.fragmetncolor.domain.ColorRepo

class App : Application(){
    val colorRepo: ColorRepo by lazy { InMemoryColorRepoImpl() }
}

val Context.app: App
get() = applicationContext as App

val Fragment.app: App
get() = requireActivity().app