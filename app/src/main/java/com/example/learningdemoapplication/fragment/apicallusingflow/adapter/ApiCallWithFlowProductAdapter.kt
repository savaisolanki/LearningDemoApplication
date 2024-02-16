package com.example.learningdemoapplication.fragment.apicallusingflow.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningdemoapplication.databinding.ApiCallWithFlowProductLayoutItemsBinding
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse

class ApiCallWithFlowProductAdapter(
    private val context: Context,
    private var productList: List<PostResponse.PostResponseItem>,
    private val onClick: (position: Int, model: PostResponse.PostResponseItem) -> Unit,
    private val onEdit: (position: Int, model: PostResponse.PostResponseItem) -> Unit,
    private val onDelete: (position: Int, model: PostResponse.PostResponseItem) -> Unit
) : RecyclerView.Adapter<ApiCallWithFlowProductAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(private val binding: ApiCallWithFlowProductLayoutItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, model: PostResponse.PostResponseItem) {
            binding.root.setOnClickListener {
                onClick.invoke(position, model)
            }
            binding.ivDelete.setOnClickListener {
                onDelete.invoke(position, model)
            }
            binding.ivUpdate.setOnClickListener {
                onEdit.invoke(position, model)
            }

            binding.tvTittle.text = model.title
            binding.tvDesc.text = model.body
            if (model.fromRoom) {
                binding.tvId.visibility = View.VISIBLE
                binding.tvId.text = model.id.toString()
                binding.ivDelete.visibility=View.VISIBLE
                binding.ivUpdate.visibility=View.VISIBLE
            } else {
                binding.tvId.visibility = View.GONE
                binding.ivDelete.visibility=View.GONE
                binding.ivUpdate.visibility=View.GONE
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ApiCallWithFlowProductLayoutItemsBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(position, productList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<PostResponse.PostResponseItem>) {
        productList = newList
        notifyDataSetChanged()
    }


}