package com.example.learningdemoapplication.fragment.apicallusingdi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningdemoapplication.databinding.ProductLayoutItemsBinding
import com.example.learningdemoapplication.fragment.apicallusingdi.model.ProductResponse

class ProductAdapter(
    private val context: Context,
    private val productList: ArrayList<ProductResponse.Product?>,
    private val onClick: (position: Int, model: ProductResponse.Product?) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(private val binding: ProductLayoutItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, model: ProductResponse.Product?) {
            binding.root.setOnClickListener {
                onClick.invoke(position, model)
            }
            binding.productDataResponse= productList[position]
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductLayoutItemsBinding.inflate(
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
}