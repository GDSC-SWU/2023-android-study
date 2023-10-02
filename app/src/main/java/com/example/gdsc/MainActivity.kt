package com.example.gdsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val frame: RelativeLayout by lazy { // activity_main의 화면 부분
        findViewById(R.id.body_container)
    }

    private val bottomNagivationView: BottomNavigationView by lazy {
        findViewById(R.id.bottom_navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(frame.id, FirstFragment()).commit()

        bottomNagivationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_first -> {
                    replaceFragment(FirstFragment())
                    true
                }

                R.id.nav_second -> {
                    replaceFragment(SecondFragment())
                    true
                }

                R.id.nav_third -> {
                    replaceFragment(ThirdFragment())
                    true
                }

                else -> false
            }
        }
    }
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(frame.id, fragment).commit()
    }
}