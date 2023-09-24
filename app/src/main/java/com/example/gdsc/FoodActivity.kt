package com.example.gdsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class FoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_introduction_gdsc_android)
        val adapter = FoodAdapter()
        val foodList = listOf(
            Food(R.drawable.img_food_buger, "Burger", "Cheese", "$8.50"),
            Food(R.drawable.img_food_taco, "Mexican Taco", "Chicken", "$6.50"),
            Food(R.drawable.img_food_cake, "Cake", "Chocolate", "$5.20"),
            Food(R.drawable.img_food_coffee, "Coffee", "Americano", "$4.70"),
            Food(R.drawable.img_food_pizza, "Pizza", "Pepperoni", "$11.50"),
        )
        recyclerView.adapter = adapter
        adapter.submitList(foodList)
    }
}