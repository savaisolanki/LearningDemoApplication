package com.example.learningdemoapplication.fragment.apicallusingflow.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.learningdemoapplication.databinding.ApiCallWithFlowProductLayoutItemsBinding
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse

class ApiCallWithFlowProductAdapter(
    private val context: Context,
    private var productList: List<PostResponse.PostResponseItem>,
    private val onClick: (position: Int, model: PostResponse.PostResponseItem) -> Unit,
    private val onEdit: (position: Int, model: PostResponse.PostResponseItem) -> Unit,
    private val onDelete: (position: Int, model: PostResponse.PostResponseItem) -> Unit
) : ListAdapter<PostResponse.PostResponseItem, ApiCallWithFlowProductAdapter.ProductViewHolder>(
    DiffUtils()
) {


    inner class ProductViewHolder(private val binding: ApiCallWithFlowProductLayoutItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(position: Int, model: PostResponse.PostResponseItem) {
            binding.root.setOnClickListener {
                onClick.invoke(position, model)
            }

             binding.root.setOnLongClickListener {
                 showDeleteConfirmationDialog(position, model)
                 true
             }

           /* binding.ivDelete.setOnClickListener {
                onDelete.invoke(position, model)
                *//*   notifyItemChanged(position)
                   notifyDataSetChanged()*//*
            }*/


            binding.ivUpdate.setOnClickListener {
                onEdit.invoke(position, model)
                //notifyDataSetChanged()
            }

            binding.tvTittle.text = model.title
            binding.tvDesc.text = model.body

            /*if (model.fromRoom) {
                binding.tvId.visibility = View.VISIBLE
                binding.tvId.text = model.id.toString()
                binding.ivDelete.visibility=View.VISIBLE
                binding.ivUpdate.visibility=View.VISIBLE
            } else {
                binding.tvId.visibility = View.GONE
                binding.ivDelete.visibility=View.GONE
                binding.ivUpdate.visibility=View.GONE
            }*/
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

    class DiffUtils() : DiffUtil.ItemCallback<PostResponse.PostResponseItem>() {
        override fun areItemsTheSame(
            oldItem: PostResponse.PostResponseItem,
            newItem: PostResponse.PostResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PostResponse.PostResponseItem,
            newItem: PostResponse.PostResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<PostResponse.PostResponseItem>) {
        productList = newList.toMutableList()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun showDeleteConfirmationDialog(position: Int, item: PostResponse.PostResponseItem) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete Item")
            .setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("Yes") { _, _ ->
                onDelete.invoke(position, item)
                notifyItemChanged(position)
                notifyDataSetChanged()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        builder.show()
    }


}