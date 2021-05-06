package com.example.recyclersample

import android.content.res.Resources
import com.example.recyclersample.data.Flower

/* Returns initial list of flowers. */
fun initFlowerList(resources: Resources): List<Flower> {
    val flowerList = ArrayList<Flower>()

    val flowerArray = resources.getStringArray(R.array.flower_array)
    for (i in flowerArray.indices) {
        flowerList.add(Flower(id = i.inc().toLong(), name = flowerArray.get(i)))
    }

    return flowerList
}