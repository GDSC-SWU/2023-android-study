package com.example.gdsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class TalkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_talk_preview)
        val adapter = TalkAdapter()
        val memberList = listOf(
            Talker(R.drawable.apeach, "이채영", "ㅋㅋㅋㅋㅋ")
        )
        recyclerView.adapter = adapter
        adapter.submitList(memberList)
    }
}