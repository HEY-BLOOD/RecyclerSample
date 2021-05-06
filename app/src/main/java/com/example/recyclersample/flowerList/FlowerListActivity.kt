package com.example.recyclersample.flowerList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.example.recyclersample.data.Datasource

class FlowerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val flowerList = Datasource(this).getFlowerList()
        val flowerAdapter = FlowerAdapter()
        flowerAdapter.submitList(flowerList)

        recyclerView.adapter = flowerAdapter
    }
}