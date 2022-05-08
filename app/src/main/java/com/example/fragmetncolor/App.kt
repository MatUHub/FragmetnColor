package com.example.fragmetncolor

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment

class App : Application(){
    val colorRepo: ColorRepo by lazy {InMemoryColorRepoImpl()}
}

val Context.app: App
get() = applicationContext as App

val Fragment.app: App
get() = requireActivity().app