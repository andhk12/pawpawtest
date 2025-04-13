package com.example.pawpawtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class Journal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

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
                date = "11 April 2069",
                title = "Grooming Tahunan",
                description = "Grooming di PawPets, bulu kotor dan kusut. Pulang dari grooming langsung kehujanan",
                imageResId = R.drawable.sample_cat
            )
        )

        val resourceList = listOf(
            ResourceEntry(
                tag = "#Grooming",
                title = "Panduan Grooming Kucing Sendiri",
                date = "12 April 2069",
                description = "Tutor dek cara mandiin kucing di rumah...",
                imageResId = R.drawable.sample_cat
            ),
            ResourceEntry(
                tag = "#Grooming",
                title = "Kucing bisa mandi sendiri",
                date = "12 April 2069",
                description = "Mandi mandi mandi~~",
                imageResId = R.drawable.sample_cat
            ),
            ResourceEntry(
                tag = "#Nutrition",
                title = "Fish oil berpengaruh pada kucing?",
                date = "12 April 2069",
                description = "Ternyata oh ternyata?",
                imageResId = R.drawable.sample_cat
            )
        )

        val recyclerViewJournal = findViewById<RecyclerView>(R.id.recycler_journal)
        recyclerViewJournal.layoutManager = LinearLayoutManager(this)
        recyclerViewJournal.adapter = JournalAdapter(journalList)
        recyclerViewJournal.setHasFixedSize(true)

        val recyclerViewResource = findViewById<RecyclerView>(R.id.recycler_resource)
        recyclerViewResource.layoutManager = LinearLayoutManager(this)
        recyclerViewResource.adapter = ResourceAdapter(resourceList)
        recyclerViewResource.setHasFixedSize(true)

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