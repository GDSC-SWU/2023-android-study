package com.example.gdsc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class NaviActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navi)

        // 하단 탭이 눌렸을 때 화면을 전환하기 위해선 이벤트 처리하기 위해 BottomNavigationView 객체 생성
        var bnv_main = findViewById<BottomNavigationView>(R.id.bnv_main)

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bnv_main.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.first -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val page01Fragment = Page01Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, page01Fragment).commit()
                }
                R.id.second -> {
                    val page02Fragment = Page02Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, page02Fragment).commit()
                }
                R.id.third -> {
                    val page03Fragment = Page03Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, page03Fragment).commit()
                }
            }
            true
        }

        // 초기 선택 항목 설정
        bnv_main.selectedItemId = R.id.first
    }
}
