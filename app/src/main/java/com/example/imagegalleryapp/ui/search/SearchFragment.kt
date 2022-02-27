package com.example.imagegalleryapp.ui.search

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegalleryapp.R
import com.example.imagegalleryapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
//import android.app.SearchManager
//import android.widget.SearchView.OnQueryTextListener
//import android.support.v7.widget.SearchView
import androidx.appcompat.widget.SearchView


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
            header = SearchPhotosLoadStateAdapter { searchPhotoAdapter.retry() },
            footer = SearchPhotosLoadStateAdapter { searchPhotoAdapter.retry() },


            )


        searchViewModel.photos.observe(viewLifecycleOwner) {
            searchPhotoAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }

        setHasOptionsMenu(true)

        return _binding.root

    }

    /*
    Code for implementing Search
     */

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_search, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if(query != null){
                    _binding.rvSearch.scrollToPosition(0)
                    searchViewModel.searchPhotos(query)
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }
}