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
            Talker(R.drawable.jenny, "이제니", "언니 언제와..","3"),
            Talker(R.drawable.chaeyoung, "이채영", "ㅋㅋㅋㅋㅋ","5"),
            Talker(R.drawable.apeach, "김유빈", "너 그럴줄 알았엌ㅋㅋ","9"),
            Talker(R.drawable.apeach, "안소연", "뭐하냐","1"),
            Talker(R.drawable.apeach, "정서영", "이따가 애들이랑 보겜ㄱ","7")
        )
        recyclerView.adapter = adapter
        adapter.submitList(memberList)
    }
}