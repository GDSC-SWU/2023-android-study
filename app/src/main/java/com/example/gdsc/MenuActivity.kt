package com.example.gdsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_menu_introduction)
        val adapter = MenuAdapter()
        val memberList = listOf(
            Menu(R.drawable.baseline_10k_24,"Macican Tacos","Cheese, Mextex, Chicken","$3.50",R.drawable.baseline_more_vert_24),
            Menu(R.drawable.baseline_10mp_24,"Make it Combo","Burger, Coke","$11.50",R.drawable.baseline_more_vert_24),
            Menu(R.drawable.baseline_11mp_24,"Make it Combo","Burger, Coke","$11.50",R.drawable.baseline_more_vert_24),
            Menu(R.drawable.baseline_12mp_24,"American Sub \nSandwich","EGG, Hamm, cheese","$3.50",R.drawable.baseline_more_vert_24),
            Menu(R.drawable.baseline_22mp_24,"American Donuts","Vanlia, Charry, Choco","$3.50",R.drawable.baseline_more_vert_24)
        )
        recyclerView.adapter = adapter
        adapter.submitList(memberList)
    }
}