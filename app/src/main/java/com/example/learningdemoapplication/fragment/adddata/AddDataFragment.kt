package com.example.learningdemoapplication.fragment.adddata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentAddDataBinding
import com.example.learningdemoapplication.fragment.apicallusingdi.viewmodel.ProductViewModel
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddDataFragment : Fragment() {
    private lateinit var binding: FragmentAddDataBinding
    private val productViewModel: ProductViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_data, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
            validation()
        }
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    /*
    * for validation
    * check empty or not else add in room database
    * */
    private fun validation() {
        if (binding.etTittle.text?.isEmpty() == true) {
            binding.etTittle.requestFocus()
            Toast.makeText(requireContext(), "Please enter tittle", Toast.LENGTH_SHORT).show()
        } else if (binding.etDesc.text?.isEmpty() == true) {
            Toast.makeText(requireContext(), "Please enter body", Toast.LENGTH_SHORT).show()
        } else {
            val addPost = PostResponse.PostResponseItem(
                title = binding.etTittle.text.toString().trim(),
                body = binding.etDesc.text.toString().trim()
            )
            productViewModel.addPostToRoom(addPost)
            Toast.makeText(requireContext(), "Data Add SuccessFully", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }

    }
}