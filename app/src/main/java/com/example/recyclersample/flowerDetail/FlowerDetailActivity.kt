package com.example.recyclersample.flowerDetail

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclersample.R
import com.example.recyclersample.flowerList.FLOWER_ID
import com.example.recyclersample.flowerList.FLOWER_NAME

class FlowerDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_detail)

        val flowerId = intent.getLongExtra(FLOWER_ID, 0)
        val flowerName = intent.getStringExtra(FLOWER_NAME)
        title = flowerName

        val flowerBodyView: TextView = findViewById(R.id.flower_body)
        flowerBodyView.text = "${flowerId}, ${flowerName}"
    }
}