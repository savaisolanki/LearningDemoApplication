package com.example.learningdemoapplication.fragment.apicallusinggrapgql.ui

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.learningdemoapplication.LaunchesQuery
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentDisplayDataBinding
import com.example.learningdemoapplication.fragment.apicallusinggrapgql.adapter.LanchesAdapter
import com.example.learningdemoapplication.fragment.apicallusinggrapgql.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayDataFragment : Fragment() {

    private val productViewModel: ProductViewModel by viewModels()
    private val productList = ArrayList<LaunchesQuery.Launch?>()
    private lateinit var lanchesAdapter: LanchesAdapter
    private lateinit var binding: FragmentDisplayDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_data, container, false)
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.getLaunchesData()
        productViewModel.response.observe(viewLifecycleOwner, Observer {
            Log.i(ContentValues.TAG, "observer: ${it.data?.launches?.launches}")

            binding.idLoadingPB.visibility = View.GONE

            if (it?.data?.launches != null) {
                productList.addAll(it.data?.launches?.launches as ArrayList<LaunchesQuery.Launch?>)
                lanchesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show()
            }

        })

        lanchesAdapter = LanchesAdapter(requireContext(), productList) { position, _ ->
            Toast.makeText(requireContext(), "${productList[position]?.site}", Toast.LENGTH_SHORT)
                .show()
        }
        binding.rvData.adapter = lanchesAdapter
    }
}