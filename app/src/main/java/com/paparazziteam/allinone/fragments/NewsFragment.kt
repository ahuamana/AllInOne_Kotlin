package com.paparazziteam.allinone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.paparazziteam.allinone.databinding.FragmentNewsBinding
import com.paparazziteam.allinone.adapters.NewsAdapter
import com.paparazziteam.allinone.viewModels.NewsViewModel

class NewsFragment : Fragment() {
    // coneccting with the viewmodel
    private val newsViewModel:NewsViewModel by viewModels<NewsViewModel>()
    private var _binding: FragmentNewsBinding? = null
    var binding: FragmentNewsBinding? = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsBinding.inflate(inflater,container,false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = newsViewModel
        }



        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel.newsList

        newsViewModel.newsList.observe(viewLifecycleOwner, {
            val adapter = NewsAdapter(it)

            binding?.recyclerView?.adapter = adapter
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}