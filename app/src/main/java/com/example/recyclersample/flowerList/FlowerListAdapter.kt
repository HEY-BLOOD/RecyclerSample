package com.example.recyclersample.flowerList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.R
import com.example.recyclersample.data.Flower

class FlowerListAdapter(private val onClick: (Flower) -> Unit) :
    ListAdapter<Flower, FlowerListAdapter.FlowerViewHolder>(FlowerDiffCallback) {

    class FlowerViewHolder(itemView: View, val onClick: (Flower) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val flowerTextView: TextView = itemView.findViewById(R.id.flower_text)
        private var currentFlower: Flower? = null

        init {
            itemView.setOnClickListener { currentFlower?.let { onClick(it) } }
        }

        fun bind(flower: Flower) {
            currentFlower = flower
            val text = "#${adapterPosition} - ${flower.id}, ${flower.name}"
            flowerTextView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flower_item, parent, false)
        return FlowerViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)
    }

}

object FlowerDiffCallback : DiffUtil.ItemCallback<Flower>() {
    override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
        return oldItem.id == newItem.id
    }
}