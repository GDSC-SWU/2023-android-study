package com.example.gdsc.starbucksorder

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc.R


class StarbucksOrderActivity : AppCompatActivity() {

    private val viewModel by viewModels<StarbucksOrderViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starbucks_order)
        initView()
    }

    private fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_starbucks_order)
        val adapter = StarbucksOrderAdapter()
        recyclerView.adapter = adapter
        adapter.submitList(viewModel.orderData)
    }
}