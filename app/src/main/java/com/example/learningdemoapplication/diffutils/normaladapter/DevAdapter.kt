package com.example.learningdemoapplication.diffutils.normaladapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.learningdemoapplication.R

class DevAdapter(private val context: Context, private val dataString: List<String>) :
    Adapter<DevViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevViewHolder {

        return DevViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.api_call_with_flow_product_layout_items, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataString.size
    }

    override fun onBindViewHolder(holder: DevViewHolder, position: Int) {
        holder.id.text = dataString[position].plus("hello")
    }
}

class DevViewHolder(data: View) : ViewHolder(data.rootView) {
    val id = data.findViewById<TextView>(R.id.tvId)
}