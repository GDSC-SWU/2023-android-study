package com.example.gdsc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

class IntroductionAdapter :
    ListAdapter<MemberDto, IntroductionAdapter.IntroductionViewHolder>(IntroductionDiffCallback2()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroductionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_week4, parent, false)
        return IntroductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroductionViewHolder, position: Int) {
        holder.bind(getItem(position)) //position에 해당하는 data type을 전달
    }

    class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val memberImage = view.findViewById<ImageView>(R.id.iv_member)
        private val memberName = view.findViewById<TextView>(R.id.tv_member_name)
        fun bind(member: MemberDto) {
            memberImage.load(member.image)
            memberName.text = member.name
        }
    }
}

class IntroductionDiffCallback2 : DiffUtil.ItemCallback<MemberDto>() {
    override fun areItemsTheSame(oldItem: MemberDto, newItem: MemberDto): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: MemberDto, newItem: MemberDto): Boolean {
        return oldItem == newItem
    }
}