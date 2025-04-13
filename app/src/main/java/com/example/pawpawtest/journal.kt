// Fix for Journal.kt
package com.example.pawpawtest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Journal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        // Dummy data
        val journalList = listOf(
            JournalEntry(
                date = "12 April 2069",
                title = "Vaksin Rabies Pertama",
                description = "Vaksin berjalan dengan lancar, tanpa efek samping.",
                imageResId = R.drawable.sample_cat
            ),
            JournalEntry(
                date = "10 April 2069",
                title = "Grooming Bulanan",
                description = "Grooming di PawCarePal, bulu bersih dan rapi.",
                imageResId = R.drawable.sample_cat
            ),
            JournalEntry(
                date = "10 April 2069",
                title = "Grooming Tahunan",
                description = "Grooming di PawCarePal, bulu kotor dan kusut. Habis pulang dari grooming, terjadi hujan badai",
                imageResId = R.drawable.sample_cat
        )

        )

        // Initialize RecyclerView with fixed height
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_journal)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = JournalAdapter(journalList)

        // Set has fixed size to true for better performance
        recyclerView.setHasFixedSize(true)

        val btnJournal = findViewById<Button>(R.id.btn_journal)
        val btnResource = findViewById<Button>(R.id.btn_resource)
        val journalLayout = findViewById<LinearLayout>(R.id.layout_journal_content)
        val resourceLayout = findViewById<LinearLayout>(R.id.layout_resource_content)

        btnJournal.setOnClickListener {
            btnJournal.setBackgroundResource(R.drawable.tab_selected)
            btnJournal.setTextColor(ContextCompat.getColor(this, android.R.color.white))

            btnResource.setBackgroundResource(R.drawable.tab_unselected)
            btnResource.setTextColor(ContextCompat.getColor(this, android.R.color.black))

            journalLayout.visibility = View.VISIBLE
            resourceLayout.visibility = View.GONE
        }

        btnResource.setOnClickListener {
            btnResource.setBackgroundResource(R.drawable.tab_selected)
            btnResource.setTextColor(ContextCompat.getColor(this, android.R.color.white))

            btnJournal.setBackgroundResource(R.drawable.tab_unselected)
            btnJournal.setTextColor(ContextCompat.getColor(this, android.R.color.black))

            journalLayout.visibility = View.GONE
            resourceLayout.visibility = View.VISIBLE
        }

    }
}