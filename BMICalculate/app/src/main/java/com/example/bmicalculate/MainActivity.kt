package com.example.bmicalculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root)

        binding.button1.setOnClickListener{
            startActivity(Intent(this@MainActivity, BmiActivity::class.java))
            finish()
        }
    }
}