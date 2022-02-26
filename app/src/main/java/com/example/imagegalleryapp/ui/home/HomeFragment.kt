package com.example.imagegalleryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegalleryapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var _binding: FragmentHomeBinding
    private var homeRecyclerAdapter = HomeRecyclerAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding.rvPhotos.layoutManager = LinearLayoutManager(requireContext())

        _binding.rvPhotos.adapter = homeRecyclerAdapter

        homeViewModel.photos.observe(viewLifecycleOwner) {
            homeRecyclerAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
        return _binding.root
    }
}

