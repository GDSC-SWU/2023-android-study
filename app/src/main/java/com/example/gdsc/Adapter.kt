package com.example.gdsc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class IntroductionAdapter :
    ListAdapter<Item, IntroductionAdapter.IntroductionViewHolder>(IntroductionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroductionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)
        return IntroductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroductionViewHolder, position: Int) {
        holder.bind(getItem(position)) //position에 해당하는 data type을 전달
    }

    class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val coffeeImage = view.findViewById<ImageView>(R.id.iv_coffee_image)
        private val coffeeName = view.findViewById<TextView>(R.id.tv_coffee_name)
        private val coffeegName = view.findViewById<TextView>(R.id.tv_coffee_egname)
        fun bind(item: Item) {
            coffeeImage.setImageDrawable(view.context.getDrawable(item.image))
            coffeeName.text = item.name
            coffeegName.text = item.egname
        }
    }
}

class IntroductionDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}