package com.example.starbucks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class StarbucksListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starbucks_list)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_starbucks_list_coffee)
        val adapter = CoffeeListAdapter()
        val memberList = listOf(
            Coffee(R.drawable.coffee1, "아이스 카페모카", "6,500원"),
            Coffee(R.drawable.coffee2, "카페 라떼", "5,500원"),
            Coffee(R.drawable.coffee3, "카페 모카", "6,000원"),
            Coffee(R.drawable.coffee4, "헤이즐넛", "5,500원"),
            Coffee(R.drawable.coffee5, "아메리카노", "4,500원"),
            Coffee(R.drawable.coffee6, "블랙 그레이즈드 라떼", "6,500원"),
            Coffee(R.drawable.coffee7, "카페 아메리카노", "5,500원"),
            Coffee(R.drawable.coffee8, "더 그린 쑥 크림 라떼", "6,500원"),
        )
        recyclerView.adapter = adapter
        adapter.submitList(memberList)
    }
}