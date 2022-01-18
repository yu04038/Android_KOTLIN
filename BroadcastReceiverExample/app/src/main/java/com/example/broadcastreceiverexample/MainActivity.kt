package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 브로드캐스트 리시버의 서브 클래스 객체 생성
        val br: BroadcastReceiver = ScreenBroadcastReceiver()

        // IntentFilter()를 이용하여 브로드캐스트 중 수신하고 싶은 메세지를 addAction()을 이용하여 추가한다.
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
        }

        // 그리고 registerReceiver()를 이용하여 브로드캐스트 리시버를 등록한다.
        registerReceiver(br, filter)
    }
}