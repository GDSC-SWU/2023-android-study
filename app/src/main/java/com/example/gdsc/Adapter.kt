package com.example.gdsc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Adapter :
    ListAdapter<member, Adapter.IntroductionViewHolder>(IntroductionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroductionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return IntroductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroductionViewHolder, position: Int) {
        holder.bind(getItem(position)) //position에 해당하는 data type을 전달
    }

    class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val memberImage = view.findViewById<ImageView>(R.id.list_image)
        private val memberName = view.findViewById<TextView>(R.id.list_name)
        private val memberSinger = view.findViewById<TextView>(R.id.list_singer)
        private val memberTime = view.findViewById<TextView>(R.id.list_time)

        fun bind(member: member) {
            memberImage.setImageDrawable(view.context.getDrawable(member.image))
            memberName.text = member.name
            memberSinger.text = member.singer
            memberTime.text = member.time

        }
    }
}

class IntroductionDiffCallback : DiffUtil.ItemCallback<member>() {
    override fun areItemsTheSame(oldItem: member, newItem: member): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: member, newItem: member): Boolean {
        return oldItem == newItem
    }
}