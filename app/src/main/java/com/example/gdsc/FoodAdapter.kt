package com.example.gdsc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter :
    ListAdapter<Food, FoodAdapter.IntroductionViewHolder>(IntroductionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroductionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return IntroductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroductionViewHolder, position: Int) {
        holder.bind(getItem(position)) //position에 해당하는 data type을 전달
    }

    class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val foodImg = view.findViewById<ImageView>(R.id.iv_img)
        private val foodName = view.findViewById<TextView>(R.id.tv_food_name)
        private val foodType = view.findViewById<TextView>(R.id.tv_type)
        private val foodPrice = view.findViewById<TextView>(R.id.tv_food_price)

        fun bind(food: Food) {
            foodImg.clipToOutline = true // 이미지 둥글게

            foodImg.setImageDrawable(view.context.getDrawable(food.img))
            foodName.text = food.name
            foodType.text = food.type
            foodPrice.text = food.price
        }
    }
}

class IntroductionDiffCallback : DiffUtil.ItemCallback<Food>() {
    override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
        return oldItem == newItem
    }
}
