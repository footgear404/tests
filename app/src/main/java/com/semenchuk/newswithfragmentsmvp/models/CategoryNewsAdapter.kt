package com.semenchuk.newswithfragmentsmvp.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.semenchuk.newswithfragmentsmvp.R

class CategoryNewsAdapter(private val categoryListOfNews: ArrayList<String>) : RecyclerView.Adapter<CategoryNewsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.category_plate, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = categoryListOfNews[position]

    }

    override fun getItemCount(): Int = categoryListOfNews.size

}