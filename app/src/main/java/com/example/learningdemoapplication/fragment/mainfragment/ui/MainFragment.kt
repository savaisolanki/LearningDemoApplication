package com.example.learningdemoapplication.fragment.mainfragment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGraphql.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDisplayDataFragment()
            findNavController().navigate(action)
        }

        binding.btnHilt.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProductListFragment()
            findNavController().navigate(action)
        }

        binding.btnFlow.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToApiCallWithFlowFragment()
            findNavController().navigate(action)
        }

        binding.btnWebView.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToWebViewDemoFragment()
            findNavController().navigate(action)
        }
    }


}