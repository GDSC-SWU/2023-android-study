package com.example.gdsc.bottomnavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gdsc.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val viewModel by viewModels<WeatherViewModel>()

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = requireNotNull(_binding) { " _binding이 nul이다 " }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun observe() {
        viewModel.getWeather.observe(viewLifecycleOwner) { response ->
            Log.d("testtest", response.toString())
        }
    }
}