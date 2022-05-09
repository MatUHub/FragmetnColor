package com.example.fragmetncolor.domain

import com.example.fragmetncolor.domain.ColorEntity

interface ColorRepo {
    fun getColor(): List<ColorEntity>
}