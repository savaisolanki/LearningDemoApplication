package com.example.learningdemoapplication.fragment.updatedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentUpdateDataBinding
import com.example.learningdemoapplication.fragment.apicallusingdi.viewmodel.ProductViewModel
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateDataFragment : Fragment() {
    private lateinit var binding: FragmentUpdateDataBinding
    private val productViewModel: ProductViewModel by viewModels()
    private val args: UpdateDataFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update_data, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*     val args = arguments

             if (args != null) {
                 val id = args.getInt("Id")
                 val title = args.getString("Tittle")
                 val body = args.getString("Body")
                 binding.etId.setText(id.toString())
                 binding.etTittle.setText(title)
                 binding.etDesc.setText(body)
             }*/


        val id = args.postItemsId
        val tittle = args.postItemsTittle
        val body = args.postItemsBody

        binding.etId.setText(id)
        binding.etTittle.setText(tittle)
        binding.etDesc.setText(body)

        binding.btnUpdate.setOnClickListener {
            validation()
        }
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    /*
    * for validation
    * check empty or not else update in room database
    * */
    private fun validation() {
        if (binding.tvTittle.text.isEmpty()) {
            binding.tvTittle.requestFocus()
            Toast.makeText(requireContext(), "Please enter tittle", Toast.LENGTH_SHORT).show()
        } else if (binding.tvDesc.text.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter body", Toast.LENGTH_SHORT).show()
        } else {
            val updatedPost = PostResponse.PostResponseItem(
                id = binding.etId.text.toString().toInt(),
                title = binding.etTittle.text.toString().trim(),
                body = binding.etDesc.text.toString().trim()
            )
            productViewModel.updatePostToRoom(updatedPost)
            Toast.makeText(requireContext(), "Data Update SuccessFully", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }

    }


}