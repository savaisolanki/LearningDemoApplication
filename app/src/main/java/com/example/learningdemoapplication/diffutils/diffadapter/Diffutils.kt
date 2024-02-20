package com.example.learningdemoapplication.diffutils.diffadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.LanchesLayoutItemsBinding
import com.example.learningdemoapplication.fragment.apicallusingflow.model.PostResponse

class Diffutils(private val context: Context,private val code:List<String>): ListAdapter<PostResponse.PostResponseItem, Diffutils.DiffutilsViewHolder>(DiffUtilsDemo()) {


    private lateinit var  binding:LanchesLayoutItemsBinding
    inner class DiffutilsViewHolder(data:View):ViewHolder(data.rootView){
        val id=data.findViewById<TextView>(R.id.tvId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffutilsViewHolder {
        return  DiffutilsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_layout_items,parent,false))
    }

    override fun getItemCount(): Int {
        return code.size
    }

    override fun onBindViewHolder(holder: DiffutilsViewHolder, position: Int) {
        holder.id.text=code[position].plus("")
    }

    class DiffUtilsDemo : DiffUtil.ItemCallback<PostResponse.PostResponseItem>(){
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
}