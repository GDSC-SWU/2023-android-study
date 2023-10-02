package com.example.gdsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gdsc.databinding.ActivityNavigationBinding

class NavigationActivity : AppCompatActivity() {

    private lateinit var navBinding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navBinding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(navBinding.root)

        // 첫 화면 설정
        supportFragmentManager.beginTransaction().add(navBinding.mainContainer.id, Fragment1()).commit()

        // 하단 네비게이션
        navBinding.bottomNav.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(Fragment1())
                    true
                }
                R.id.nav_search -> {
                    replaceFragment(Fragment2())
                    true
                }
                R.id.nav_add -> {
                    replaceFragment(Fragment3())
                    true
                }
                else -> false
            }
        }
    }

    // 화면 전환 구현 메소드
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(navBinding.mainContainer.id, fragment).commit()
    }
}