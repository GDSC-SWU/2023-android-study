package com.example.gdsc.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.gdsc.R
import com.example.gdsc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 애플리케이션 실행 후 첫 화면 설정
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fl_bottom_naviation_layout, CalendarFragment())
            .commit()

        // 하단 네비게이션 바 클릭 이벤트 설정
        binding.bnvBottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_bottom_navigation_calendar -> {
                    replaceFragment(CalendarFragment())
                    true
                }
                R.id.nav_bottom_navigation_charts -> {
                    replaceFragment(ChartFragment())
                    true
                }
                R.id.nav_bottom_navigation_comments -> {
                    replaceFragment(CommentFragment())
                    true
                }
                else -> false
            }
        }
    }

    // 화면 전환 구현 메소드
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_bottom_naviation_layout, fragment)
            .commit()
    }
}