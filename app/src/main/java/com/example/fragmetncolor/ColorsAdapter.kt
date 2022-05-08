package com.example.fragmetncolor

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ColorsAdapter : RecyclerView.Adapter<ColorViewHolder>() {
    private var data: List<ColorEntity> = emptyList()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ColorViewHolder.createView(parent)


    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(pos: Int) = data[pos]

    override fun getItemCount() = data.size

}
