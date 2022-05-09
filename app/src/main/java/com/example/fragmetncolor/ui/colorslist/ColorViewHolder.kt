package com.example.fragmetncolor.ui.colorslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmetncolor.domain.ColorEntity
import com.example.fragmetncolor.R
import com.example.fragmetncolor.databinding.ItemColorBinding


class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemColorBinding.bind(itemView)

    companion object {
        fun createView(parent: ViewGroup): ColorViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
            return ColorViewHolder(view)
        }
    }

    fun bind(item: ColorEntity, listener: (ColorEntity) -> Unit) {
        binding.root.setOnClickListener {
            listener.invoke(item)
        }
        binding.colorNameTextView.text = item.name
        binding.root.setBackgroundColor(item.color)

    }
}