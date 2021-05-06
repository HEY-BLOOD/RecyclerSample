package com.example.recyclersample.flowerList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.example.recyclersample.data.Datasource
import com.example.recyclersample.data.Flower
import com.example.recyclersample.flowerDetail.FlowerDetailActivity

const val FLOWER_ID = "flower id"
const val FLOWER_NAME = "flower name"

class FlowerListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_list)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val flowerList = Datasource(this).getFlowerList()
        val flowerListAdapter = FlowerListAdapter { flower -> adapterOnClick(flower) }
        flowerListAdapter.submitList(flowerList)

        recyclerView.adapter = flowerListAdapter
    }

    private fun adapterOnClick(flower: Flower) {
        val intent = Intent(this, FlowerDetailActivity()::class.java)
        intent.putExtra(FLOWER_ID, flower.id)
        intent.putExtra(FLOWER_NAME, flower.name)
        startActivity(intent)

        val message = "${flower.id}, ${flower.name}"
        Log.d("adapter clicked", message)
    }
}