package com.example.pawpawtest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResourceActivity : AppCompatActivity() {

    companion object {
        private const val ADD_RESOURCE_REQUEST_CODE = 1
    }

    private lateinit var adapter: ResourceAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyState: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        recyclerView = findViewById(R.id.recycler_resource)
        emptyState = findViewById(R.id.empty_state_container)

        adapter = ResourceAdapter(mutableListOf()) // Awal kosong
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        findViewById<Button>(R.id.btn_journal).setOnClickListener {
            val intent = Intent(this, JournalActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)

        }

        findViewById<Button>(R.id.btn_add_resource).setOnClickListener {
            startActivityForResult(
                Intent(this, AddResourceActivity::class.java),
                ADD_RESOURCE_REQUEST_CODE
            )
        }

        checkEmptyState()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_RESOURCE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val tag = data.getStringExtra("resource_tag")
            val date = data.getStringExtra("resource_date")
            val title = data.getStringExtra("resource_title")
            val desc = data.getStringExtra("resource_description")
            val image = data.getIntExtra("resource_image_res", R.drawable.sample_cat)

            if (!tag.isNullOrBlank() && !date.isNullOrBlank() && !title.isNullOrBlank() && !desc.isNullOrBlank()) {
                val newEntry = ResourceEntry(tag, title, date, desc, image)
                adapter.addEntry(newEntry)
                checkEmptyState()
            }
        }
    }

    private fun checkEmptyState() {
        if (adapter.itemCount == 0) {
            recyclerView.visibility = View.GONE
            emptyState.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyState.visibility = View.GONE
        }
    }
}
