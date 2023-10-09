package com.example.gdsc
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Member
import android.util.Log
import com.example.gdsc.databinding.ActivityWeek4Binding
import retrofit2.Call
import retrofit2.Response


class Week4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityWeek4Binding
    private val getMemberService = ServicePool.getMember
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeek4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        getMemberApi()
    }

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
    }
}