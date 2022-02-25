package com.example.imagegalleryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegalleryapp.adapter.LoadingStateAdapter
import com.example.imagegalleryapp.adapter.PhotosAdapter
import com.example.imagegalleryapp.databinding.FragmentHomeBinding
import com.example.imagegalleryapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var photosAdapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.getAllPhotos()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecyclerView()

        lifecycleScope.launchWhenCreated {
            homeViewModel.getAllPhotos().collect { response ->
                _binding.apply {
                    rvPhotos.isVisible = true
                    progressBar.isVisible = false
                }
                photosAdapter.submitData(response)
            }
        }
        return _binding.root
    }

    private fun initRecyclerView() {
        _binding.apply {
            rvPhotos.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                _binding.rvPhotos.adapter = photosAdapter.withLoadStateHeaderAndFooter(
                    header = LoadingStateAdapter{photosAdapter.retry()},
                    footer = LoadingStateAdapter{photosAdapter.retry()}
                )
            }
        }
    }
}