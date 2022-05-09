package com.example.fragmetncolor.data

import android.graphics.Color
import com.example.fragmetncolor.domain.ColorEntity
import com.example.fragmetncolor.domain.ColorRepo
import java.util.*

class InMemoryColorRepoImpl: ColorRepo {
    override fun getColor(): List<ColorEntity> {
        return listOf(
            ColorEntity(generateId(), "Blue", Color.BLUE),
            ColorEntity(generateId(), "Red", Color.RED),
            ColorEntity(generateId(), "Green", Color.GREEN),
            ColorEntity(generateId(), "Yellow", Color.YELLOW),
            ColorEntity(generateId(), "Cyan", Color.CYAN)
        )
    }

    private fun generateId() = UUID.randomUUID().toString()

}