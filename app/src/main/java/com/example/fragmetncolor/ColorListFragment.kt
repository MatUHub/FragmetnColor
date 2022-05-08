package com.example.fragmetncolor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmetncolor.databinding.FragmentColorsListBinding

class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    private val colorAdapter = ColorsAdapter()
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
}