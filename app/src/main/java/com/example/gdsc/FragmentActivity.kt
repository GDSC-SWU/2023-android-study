package com.example.gdsc

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        // BottomNavigationView 객체 생성
        var bnv = findViewById(R.id.navigationView) as BottomNavigationView

        // OnNavigationItemSelectedListener를: 탭 아이템 선택 시 이벤트를 처리
        // navi_bar.xml 에서 설정한 아이템들의 id로 알맞은 프래그먼트로 변경
        bnv.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.fm_first -> {
                    // 다른 프래그먼트 화면으로 이동
                    val firstFragment = FirstFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_origin, firstFragment).commit()
                }
                R.id.fm_second -> {
                    val secondFragment = SecondFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_origin, secondFragment).commit()
                }
                R.id.fm_third -> {
                    val thirdFragment = ThirdFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_origin, thirdFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.tv_first
        }
    }
}

