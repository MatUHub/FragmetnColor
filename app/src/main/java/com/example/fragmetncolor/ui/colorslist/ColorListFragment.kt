package com.example.fragmetncolor.ui.colorslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmetncolor.domain.ColorRepo
import com.example.fragmetncolor.R
import com.example.fragmetncolor.app
import com.example.fragmetncolor.databinding.FragmentColorsListBinding
import com.example.fragmetncolor.domain.ColorEntity
import com.example.fragmetncolor.ui.colorview.ColorViewerFragment
import java.lang.IllegalStateException

class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    private val colorAdapter = ColorsAdapter{
        controller.openColorScreen(it)
    }
    private val colorRepo: ColorRepo by lazy{ app.colorRepo}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentColorsListBinding.bind(view)
        binding.colorsRecyclerView
        initRecycler()
    }

    private fun initRecycler() {
        binding.colorsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = colorAdapter
        }
        colorAdapter.data = colorRepo.getColor()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_colors_list, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface Controller{
        fun openColorScreen(color: ColorEntity)
    }

    private val controller by lazy {activity as Controller}


    override fun onAttach(context: Context) {
        super.onAttach(context)
       if(activity !is Controller)
           throw IllegalStateException("Наследование от контроллера")
    }
}