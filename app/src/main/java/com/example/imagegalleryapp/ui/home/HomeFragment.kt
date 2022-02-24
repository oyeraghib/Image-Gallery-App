package com.example.imagegalleryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegalleryapp.databinding.FragmentHomeBinding
import com.example.imagegalleryapp.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    private var homeRecyclerAdapter = HomeRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.fetchPhotosList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding.rvPhotos.layoutManager = LinearLayoutManager(requireContext())
        _binding.rvPhotos.adapter = homeRecyclerAdapter

        homeViewModel.photos.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "Total item received ${it.size}", Toast.LENGTH_SHORT)
                .show()
            homeRecyclerAdapter.submitList(it)
        })
        return _binding.root
    }
}