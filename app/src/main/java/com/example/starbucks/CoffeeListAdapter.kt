package com.example.starbucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class CoffeeListAdapter : ListAdapter<Coffee, CoffeeListAdapter.CoffeeListViewHolder>(IntroductionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return CoffeeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeListViewHolder, position: Int) {
        holder.bind(getItem(position)) //position에 해당하는 data type을 전달
    }

    class CoffeeListViewHolder(private val view: View)
        : RecyclerView.ViewHolder(view) {
        private val coffeeImage = view.findViewById<ImageView>(R.id.iv_item_coffee)
        private val coffeeTitle = view.findViewById<TextView>(R.id.tv_item_coffee_title)
        private val coffeePrice = view.findViewById<TextView>(R.id.tv_item_coffee_price)

        fun bind(member: Coffee) {
            coffeeImage.setImageDrawable(view.context.getDrawable(member.image))
            coffeeTitle.text = member.title
            coffeePrice.text = member.price
        }
    }
}

class IntroductionDiffCallback : DiffUtil.ItemCallback<Coffee>() {
    override fun areItemsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
        return oldItem == newItem
    }
}