package com.example.fragmetncolor.ui.colorview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmetncolor.R
import com.example.fragmetncolor.databinding.FragmentColorViewerBinding
import com.example.fragmetncolor.domain.ColorEntity
import java.lang.IllegalStateException

class ColorViewerFragment: Fragment(R.layout.fragment_color_viewer) {
private val binding by viewBinding(FragmentColorViewerBinding::class.java)

    companion object {
        private const val COLOR_ARGS_KEY = "COLOR_ARGS_KEY"
        fun newInstance(colorEntity: ColorEntity) =
            ColorViewerFragment().apply {
                arguments = Bundle()
                arguments?.putParcelable(COLOR_ARGS_KEY, colorEntity)
        }
    }

    private fun getColorFromArguments(): ColorEntity{
       return arguments?.getParcelable<ColorEntity>(COLOR_ARGS_KEY)?:
       throw IllegalStateException("Забыли цвет")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = getColorFromArguments()
        binding.root.setBackgroundColor(color.color)
        binding.nameTextView.text = color.name
        binding.redValueEditText.setText(Color.red(color.color).toString())
        binding.redValueEditText.setText(Color.green(color.color).toString())
        binding.redValueEditText.setText(Color.blue(color.color).toString())
    }
}