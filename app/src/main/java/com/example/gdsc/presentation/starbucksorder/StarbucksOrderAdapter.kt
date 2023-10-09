package com.example.gdsc.presentation.starbucksorder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.gdsc.ItemDiffCallback
import com.example.gdsc.R
import com.example.gdsc.presentation.starbucksorder.viewholder.StarbucksOrderViewHolder

class StarbucksOrderAdapter : ListAdapter<StarbucksOrder, StarbucksOrderViewHolder>(
    StarbucksOrderDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarbucksOrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_starbucks_order, parent, false)
        return StarbucksOrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarbucksOrderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val StarbucksOrderDiffCallback =
            ItemDiffCallback<StarbucksOrder>(onItemsTheSame = { old, new -> old.tittle == new.tittle },
                onContentsTheSame = { old, new -> old == new })
    }
}