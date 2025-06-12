package com.example.pawpawtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JournalAdapter(private val journals: MutableList<JournalEntry>) :
    RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {

    class JournalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.text_date)
        val title: TextView = itemView.findViewById(R.id.text_title)
        val description: TextView = itemView.findViewById(R.id.text_description)
        val image: ImageView = itemView.findViewById(R.id.image_journal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_journal_entry, parent, false)
        return JournalViewHolder(view)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        val journal = journals[position]
        holder.date.text = journal.date
        holder.title.text = journal.title
        holder.description.text = journal.description
        holder.image.setImageResource(journal.imageResId)
    }

    override fun getItemCount(): Int = journals.size

    fun addEntry(entry: JournalEntry) {
        journals.add(0, entry)
        notifyItemInserted(0)
    }

    fun removeEntry(position: Int) {
        journals.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getEntry(position: Int): JournalEntry {
        return journals[position]
    }

    fun restoreEntry(entry: JournalEntry, position: Int) {
        journals.add(position, entry)
        notifyItemInserted(position)
    }
}
