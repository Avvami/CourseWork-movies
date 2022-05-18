package com.bignerdranch.android.coursework_movies.screens.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.coursework_movies.R
import com.bignerdranch.android.coursework_movies.data.ResourceData

class rvAdapter(private val resourceList : ArrayList<ResourceData>) : RecyclerView.Adapter<rvAdapter.rvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return rvViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: rvViewHolder, position: Int) {

        val currentItem = resourceList[position]

        holder.resourceTitle.text = currentItem.name
        holder.resourceGenre.text = currentItem.genre
        holder.resourceYear.text = currentItem.year
    }

    override fun getItemCount(): Int {

        return resourceList.size
    }

    class rvViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val resourceTitle : TextView = itemView.findViewById(R.id.resource_title)
        val resourceGenre : TextView = itemView.findViewById(R.id.resource_genre)
        val resourceYear : TextView = itemView.findViewById(R.id.resource_year)
    }
}