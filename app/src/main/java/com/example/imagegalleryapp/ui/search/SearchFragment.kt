package com.example.imagegalleryapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.imagegalleryapp.R
import com.example.imagegalleryapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSearchBinding.bind(view)

        val adapter = SearchPhotosAdapter()

        binding.apply {
            rvSearch.setHasFixedSize(true)
            rvSearch.adapter = adapter
        }

        searchViewModel.photos.observe(this, Observer {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}