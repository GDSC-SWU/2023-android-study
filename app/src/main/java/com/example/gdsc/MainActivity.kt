package com.example.gdsc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gdsc.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val getMemberService = ServicePool.getMember
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMemberApi()
    }

    private fun getMemberApi() {
//        val adapter = IntroductionAdapter()
//        binding.rvIntroductionGdscAndroid.adapter = adapter
        getMemberService.getMember().enqueue(object : retrofit2.Callback<MemberDto> {
            override fun onResponse(
                call: Call<MemberDto>, response: Response<MemberDto>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { Log.d("result", it.toString()) }
                } else {
                    Log.d("error", "실패한 응답")
                }
            }

            override fun onFailure(call: Call<MemberDto>, t: Throwable) {
                t.message?.let { Log.d("error", it) } ?: "서버통신 실패(응답값 X)"
            }

        })
    }
}