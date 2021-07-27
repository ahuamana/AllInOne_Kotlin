package com.paparazziteam.allinone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.paparazziteam.allinone.databinding.FragmentHomeBinding
import com.paparazziteam.allinone.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    val homeViewModel: HomeViewModel by viewModels<HomeViewModel>()


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
           lifecycleOwner = viewLifecycleOwner
           viewmodel = homeViewModel
       }




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}