package com.example.recyclersample.data

import android.content.Context
import com.example.recyclersample.initFlowerList

class Datasource(val context: Context) {
    fun getFlowerList(): List<Flower> {
        return initFlowerList(context.resources)
    }
}