package com.example.gdsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_coffee)
        val adapter = IntroductionAdapter()
        val itemList = listOf(
            Item(R.drawable.coffee1, "미키 딜라이트 콜드 브루","Mickey Delight Cold Brew"),
            Item(R.drawable.coffee2, "콜드 브루","Cold Brew"),
            Item(R.drawable.coffee3, "나이트로 바닐라 크림","Nitro Vanilla Cold Brew"),
            Item(R.drawable.coffee4, "제주 비자림 콜드 브루","Jeju Forest Cold Brew"),
            Item(R.drawable.coffee5, "제주 시트러스 허니 콜드 브루","Jeju Citrus Honey Cold Brew"),
        )
        recyclerView.adapter = adapter
        adapter.submitList(itemList)
    }
}