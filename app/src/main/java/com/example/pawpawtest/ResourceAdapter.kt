package com.example.pawpawtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResourceAdapter(private val resources: List<ResourceEntry>) :
    RecyclerView.Adapter<ResourceAdapter.ResourceViewHolder>() {

    class ResourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tag: TextView = itemView.findViewById(R.id.text_tag)
        val title: TextView = itemView.findViewById(R.id.text_title)
        val date: TextView = itemView.findViewById(R.id.text_date)
        val description: TextView = itemView.findViewById(R.id.text_description)
        val image: ImageView = itemView.findViewById(R.id.image_resource)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_resource_entry, parent, false)
        return ResourceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val resource = resources[position]
        holder.tag.text = resource.tag
        holder.title.text = resource.title
        holder.date.text = resource.date
        holder.description.text = resource.description
        holder.image.setImageResource(resource.imageResId)
    }

    override fun getItemCount(): Int = resources.size
}
