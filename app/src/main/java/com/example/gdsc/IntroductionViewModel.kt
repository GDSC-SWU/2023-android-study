package com.example.gdsc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class IntroductionViewModel : ViewModel() {
    private val _getMember: MutableLiveData<List<MemberDto>> = MutableLiveData()  //read, write
    val getMember: LiveData<List<MemberDto>> = _getMember //read
    private val getMemberService = ServicePool.getMember

    init {
        getMember()
    }

    private fun getMember() {
        getMemberService.getMember().enqueue(object : retrofit2.Callback<List<MemberDto>> {
            override fun onResponse(
                call: Call<List<MemberDto>>, response: Response<List<MemberDto>>
            ) {
                if (response.isSuccessful) {
                    _getMember.value = response.body()
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