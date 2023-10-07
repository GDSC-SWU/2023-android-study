package com.example.gdsc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter :
    ListAdapter<Menu, MenuAdapter.MenuViewHolder>(MenuDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position)) //position에 해당하는 data type을 전달
    }

    class MenuViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val menuImage = view.findViewById<ImageView>(R.id.iv_menu)
        private val menuName = view.findViewById<TextView>(R.id.tv_menu_name)
        private val memberIngredient = view.findViewById<TextView>(R.id.tv_menu_ingredient)
        private val memberPrice = view.findViewById<TextView>(R.id.tv_menu_price)
        private val menuImage_add = view.findViewById<ImageView>(R.id.iv_add)
        fun bind(menu: Menu) {
            menuImage.setImageDrawable(AppCompatResources.getDrawable(view.context, menu.image))
            menuName.text = menu.name
            memberIngredient.text = menu.ingredient
            memberPrice.text = menu.price
            menuImage_add.setImageDrawable(AppCompatResources.getDrawable(view.context, menu.image_add))
        }
    }
}

class MenuDiffCallback : DiffUtil.ItemCallback<Menu>() {
    override fun areItemsTheSame(oldItem: Menu, newItem: Menu): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Menu, newItem: Menu): Boolean {
        return oldItem == newItem
    }
}