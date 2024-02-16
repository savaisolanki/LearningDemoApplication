package com.example.learningdemoapplication.fragment.apicallusingdi.ui

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
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentProductListBinding
import com.example.learningdemoapplication.fragment.apicallusingdi.adapter.ProductAdapter
import com.example.learningdemoapplication.fragment.apicallusingflow.adapter.ApiCallWithFlowProductAdapter
import com.example.learningdemoapplication.fragment.apicallusingdi.model.ProductResponse
import com.example.learningdemoapplication.fragment.apicallusingdi.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var binding: FragmentProductListBinding

    private val productList = ArrayList<ProductResponse.Product?>()

    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.getProduct()
        productViewModel.response.observe(viewLifecycleOwner, Observer {
            Log.i(ContentValues.TAG, "observer: ${it.products}")
            binding.idLoadingPB.visibility = View.GONE

            if (it?.products != null) {
                productList.addAll(it.products as java.util.ArrayList<ProductResponse.Product?>)
                productAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT).show()
            }

        })

        productAdapter = ProductAdapter(requireContext(), productList) { position, model ->
            Toast.makeText(requireContext(), "${productList[position]?.brand}", Toast.LENGTH_SHORT)
                .show()
        }
        binding.rvData.adapter = productAdapter

    }


}