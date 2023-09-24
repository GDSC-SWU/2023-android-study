package com.example.gdsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_introduction_gdsc_android)
        val adapter = Adapter()
        val memberList = listOf(
            member(R.drawable.img1, "Love Lee", "AKMU (악뮤)", "3:00"),
            member(R.drawable.img2, "투게더!", "잔나비", "3:07"),
            member(R.drawable.img3, "초록을거머쥔우리는", "잔나비", "3:24"),
            member(R.drawable.img4, "좋아해.. (바른연애 길잡이 X 죠지)","죠지", "4:09"),
            member(R.drawable.img5, "바라바줘요", "죠지", "4:12"),
            member(R.drawable.img6, "흔들리는 꽃들 속에서 네 삼푸향이 느껴진거야", "장범준", "2:49")
        )
        recyclerView.adapter = adapter
        adapter.submitList(memberList)
    }
}