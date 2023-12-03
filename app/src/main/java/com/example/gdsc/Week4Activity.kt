package com.example.gdsc
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.gdsc.databinding.ActivityWeek4Binding


class Week4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityWeek4Binding
    // private val getMemberService = ServicePool.getMember
    private val viewModel by viewModels<IntroductionViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeek4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observeGetMember()
        //getMemberApi()
    }

    private fun observeGetMember() {
        viewModel.getMember.observe(this) { getMemberResult ->
            val adapter = IntroductionAdapter()
            binding.rvIntroductionGdscAndroid.adapter = adapter
            adapter.submitList(getMemberResult)
        }
    }
/*
    private fun getMemberApi() {
        val adapter = IntroductionAdapter()
        binding.rvIntroductionGdscAndroid.adapter = adapter
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
    }*/
}