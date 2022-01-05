package com.example.bmicalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bmicalculate.databinding.ActivityMainBinding
import com.example.bmicalculate.databinding.LayoutViewBindingBinding

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // UI로 사용할 레이아웃 XML 파일을 지정한다.
        setContentView(R.layout.layout_view_binding)

        // bmi 버튼이 클릭된 경우 동작하는 코드 작성
        val binding = LayoutViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bmiButton.setOnClickListener {
            Log.e("bmi", "ok");
            // tallField 값을 읽어온다.
            val tall = binding.tallField.text.toString().toDouble();

            // weightField 값을 읽어온다.
            val weight = binding.weightField.text.toString().toDouble();

            // BMI 계산 (pow는 제곱)
            val bmi = weight / Math.pow(tall / 100, 2.0)

            // 결과 BMI를 resultLabel에 보여준다.
            binding.resultLabel.text = "키: ${binding.tallField.text}, 체중: ${binding.weightField.text}, " +
                    "BMI: $bmi"
        }
    }
}