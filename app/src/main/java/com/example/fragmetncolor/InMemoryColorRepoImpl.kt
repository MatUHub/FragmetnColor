package com.example.fragmetncolor

import android.graphics.Color
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