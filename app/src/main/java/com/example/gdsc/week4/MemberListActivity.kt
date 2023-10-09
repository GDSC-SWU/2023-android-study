package com.example.gdsc.week4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gdsc.databinding.ActivityMemberListBinding
import retrofit2.Call
import retrofit2.Response


class MemberListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMemberListBinding
    private val getMemberService = ServicePool.getMember
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMemberApi()
    }

    private fun getMemberApi() {
        val adapter = MemberAdapter()
        binding.rvMemberList.adapter = adapter

        getMemberService.getMember().enqueue(object : retrofit2.Callback<List<MemberDto>> {
            override fun onResponse(
                call: Call<List<MemberDto>>, response: Response<List<MemberDto>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { adapter.submitList(it) }
                } else {
                    Log.d("error", "실패한 응답")
                }
            }

            override fun onFailure(call: Call<List<MemberDto>>, t: Throwable) {
                t.message?.let { Log.d("error", it) } ?: "서버통신 실패(응답값 X)"
            }
        })
    }
}