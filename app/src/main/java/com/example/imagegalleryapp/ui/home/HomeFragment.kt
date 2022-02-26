package com.example.imagegalleryapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

//    private lateinit var _binding: FragmentHomeBinding
//    private val homeViewModel: HomeViewModel by viewModels()
//
//    @Inject
//    lateinit var photosAdapter: PhotosAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        homeViewModel.getAllPhotos()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null

    }
}
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        initRecyclerView()
//
//        lifecycleScope.launchWhenCreated {
//            homeViewModel.getAllPhotos().collect { response ->
//                _binding.apply {
//                    rvPhotos.isVisible = true
//                    progressBar.isVisible = false
//                }
//                photosAdapter.submitData(response)
//            }
//        }
//        return _binding.root

//    private fun initRecyclerView() {
//        _binding.apply {
//            rvPhotos.apply {
//                setHasFixedSize(true)
//                layoutManager = LinearLayoutManager(requireContext())
//                _binding.rvPhotos.adapter = photosAdapter.withLoadStateHeaderAndFooter(
//                    header = LoadingStateAdapter{photosAdapter.retry()},
//                    footer = LoadingStateAdapter{photosAdapter.retry()}
//                )
//            }
//        }
//    }
