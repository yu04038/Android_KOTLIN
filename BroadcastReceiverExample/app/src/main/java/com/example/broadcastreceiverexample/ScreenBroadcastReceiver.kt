package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ScreenBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // 화면이 켜졌을 때, "good"이라는 토스트 메세지를 출력하도록 명시
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Log.e("broadcast", "good")
            var toast = Toast.makeText(context, "good", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}