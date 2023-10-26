package com.example.gdsc.week4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.gdsc.R

class MemberAdapter :
    ListAdapter<MemberDto, MemberAdapter.IntroductionViewHolder>(IntroductionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroductionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.member_item, parent, false)
        return IntroductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroductionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val memberImage = view.findViewById<ImageView>(R.id.iv_member_item_img)
        private val memberName = view.findViewById<TextView>(R.id.tv_member_item_name)
        fun bind(member: MemberDto) {
            memberImage.load(member.image)
            memberName.text = member.name
        }
    }
}

class IntroductionDiffCallback : DiffUtil.ItemCallback<MemberDto>() {
    override fun areItemsTheSame(oldItem: MemberDto, newItem: MemberDto): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MemberDto, newItem: MemberDto): Boolean {
        return oldItem == newItem
    }
}