package com.example.imagegalleryapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegalleryapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private lateinit var _binding: FragmentSearchBinding

    private var searchPhotoAdapter = SearchPhotosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        _binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())

        _binding.rvSearch.adapter = searchPhotoAdapter.withLoadStateHeaderAndFooter(
            header = SearchPhotosLoadStateAdapter {searchPhotoAdapter.retry()},
            footer = SearchPhotosLoadStateAdapter {searchPhotoAdapter.retry()},


        )


        searchViewModel.photos.observe(viewLifecycleOwner) {
            searchPhotoAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        return _binding.root

    }

}