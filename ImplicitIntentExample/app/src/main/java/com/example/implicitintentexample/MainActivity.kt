package com.example.implicitintentexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val button: Button by lazy { findViewById<Button>(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            var uri = Uri.parse("content://sdcard/Download/music.mp3")
            intent.setDataAndType(uri, "audio/mp3")

            // Chooser 생성
            val chooser = Intent.createChooser(intent, "Open with")

            startActivity(chooser)
        }
    }
}