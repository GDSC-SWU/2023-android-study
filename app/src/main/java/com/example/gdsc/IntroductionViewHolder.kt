package com.example.gdsc

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import java.lang.reflect.Member

class IntroductionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val memberImage = view.findViewById<ImageView>(R.id.iv_member)
    private val memberName = view.findViewById<TextView>(R.id.tv_member_name)
    fun bind(member: MemberDto) {
        memberImage.load(member.image)
        memberName.text = member.name
    }
}