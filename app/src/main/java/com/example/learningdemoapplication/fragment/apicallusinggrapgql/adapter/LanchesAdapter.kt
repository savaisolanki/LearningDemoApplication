package com.example.learningdemoapplication.fragment.apicallusinggrapgql.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningdemoapplication.LaunchesQuery
import com.example.learningdemoapplication.databinding.LanchesLayoutItemsBinding

class LanchesAdapter(
    private val context: Context,
    private val productList: ArrayList<LaunchesQuery.Launch?>,
    private val onClick: (position: Int, model: LaunchesQuery.Launch?) -> Unit
) : RecyclerView.Adapter<LanchesAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(private val binding: LanchesLayoutItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int, model: LaunchesQuery.Launch?) {
            binding.root.setOnClickListener {
                onClick.invoke(position, model)
            }
            binding.productDataResponse = productList[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LanchesLayoutItemsBinding.inflate(
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