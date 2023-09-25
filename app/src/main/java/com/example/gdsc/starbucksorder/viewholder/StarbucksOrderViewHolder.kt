package com.example.gdsc.starbucksorder.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gdsc.R
import com.example.gdsc.starbucksorder.StarbucksOrder

class StarbucksOrderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val orderImage = view.findViewById<ImageView>(R.id.iv_starbucks_order_img)
    private val orderTitle = view.findViewById<TextView>(R.id.tv_starbucks_order_title)
    private val orderEngTitle = view.findViewById<TextView>(R.id.tv_starbucks_order_eng_title)
    fun bind(data: StarbucksOrder) {
        orderImage.load(data.image)
        orderTitle.text = data.tittle
        orderEngTitle.text = data.engTitle
    }
}