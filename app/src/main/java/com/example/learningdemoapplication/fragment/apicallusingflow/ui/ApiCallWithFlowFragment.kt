package com.example.learningdemoapplication.fragment.apicallusingflow.ui

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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentApiCallWithFlowBinding
import com.example.learningdemoapplication.fragment.apicallusingdi.viewmodel.ProductViewModel
import com.example.learningdemoapplication.fragment.apicallusingflow.adapter.ApiCallWithFlowProductAdapter
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import com.example.learningdemoapplication.fragment.updatedata.UpdateDataFragment
import com.example.learningdemoapplication.utils.ResponseHandler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ApiCallWithFlowFragment : Fragment() {

    private lateinit var binding: FragmentApiCallWithFlowBinding

    private val productViewModel: ProductViewModel by viewModels()

    private val productList = ArrayList<PostResponse.PostResponseItem>()

    private lateinit var productAdapter: ApiCallWithFlowProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_api_call_with_flow,
            container,
            false
        )
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.getAllPosts()
        initRecyclerView()
        observeViewModel()

    }


    private fun initRecyclerView() {

        productAdapter = ApiCallWithFlowProductAdapter(requireContext(), productList,
            { position, model ->
                Toast.makeText(requireContext(), "Clicked item: ${productList[position].title}", Toast.LENGTH_SHORT).show()
            },
            { position, model ->
                val bundle=Bundle()
                bundle.putInt("Id",model.id)
                bundle.putString("Tittle",model.title)
                bundle.putString("Body",model.body)
                val destinationFragment = UpdateDataFragment()

                destinationFragment.arguments = bundle

                findNavController().navigate(R.id.action_apiCallWithFlowFragment_to_updateDataFragment,bundle)

            },
            { position, model ->

            }
        )
        binding.rvData.adapter = productAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeViewModel() {

        lifecycleScope.launch {
            productViewModel.dataPost.collect {
                when (it) {
                    is ResponseHandler.Loading -> {
                        Log.i(ContentValues.TAG, "observer: $it")
                    }

                    is ResponseHandler.OnSuccessResponse -> {
                        binding.idLoadingPB.visibility = View.GONE

                        if (it.response.isEmpty()) {
                            Toast.makeText(requireContext(), "Data Not Found", Toast.LENGTH_SHORT)
                                .show()

                        } else {
                            productList.clear()
                            Log.i(ContentValues.TAG, "observer: ${it.response}")
                            productList.addAll(it.response)
                            productAdapter.notifyDataSetChanged()

                        }
                    }

                    is ResponseHandler.OnFailed -> {
                        Log.i(ContentValues.TAG, "observer: ${it.code}")
                    }

                }
            }
        }
    }
}