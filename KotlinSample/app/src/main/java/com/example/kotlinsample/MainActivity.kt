package com.example.kotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinsample.databinding.ActivityMainBinding

// 코틀린에서는 상속을 사용하기 위해 ":"를 사용한다.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 바인딩 초기화
        val binding = ActivityMainBinding.inflate(layoutInflater);

        // 2. 레이아웃(root뷰) 표시
        setContentView(binding.root);

        // 3-1.뷰바인딩으로 버튼 접근
        binding.button1.setOnClickListener {

            // 3-2. 뷰바인딩으로 텍스트뷰 접근
            binding.button1.text = "바인딩이 잘 되네요!";
        }
    }
}