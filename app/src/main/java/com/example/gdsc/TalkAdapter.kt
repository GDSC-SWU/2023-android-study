package com.example.gdsc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class TalkAdapter :
    ListAdapter<MemberDto, TalkAdapter.IntroductionViewHolder>(IntroductionDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroductionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return IntroductionViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroductionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val memberImage = view.findViewById<ImageView>(R.id.iv_member)
        private val memberName = view.findViewById<TextView>(R.id.tv_member_name)
        private val memberTalk = view.findViewById<TextView>(R.id.tv_talk)
        private val talkNumber = view.findViewById<Button>(R.id.btn_number)
        fun bind(member: MemberDto) {
            memberImage.setImageDrawable(view.context.getDrawable(member.image))
            memberName.text = member.name
            //memberTalk.text = member.talk
           // talkNumber.text = member.number
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