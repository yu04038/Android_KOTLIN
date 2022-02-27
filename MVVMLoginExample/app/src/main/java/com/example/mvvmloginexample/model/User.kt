package com.example.mvvmloginexample.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

// 바인딩하려는 객체에 observable 인터페이스를 구현하면 해당 객체에 단일 리스너를 연결하여 그 객체의 모든 속성의 변경사항을 수신할 수 있다.
data class User(private var email: String, private var password: String ): BaseObservable() {

    fun isDataValid():Int {
        if(TextUtils.isEmpty(getEmail()))
            return 0 // 0 code is email empty
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1 // 1 code is wrong email pattern
        else if (getPassword().length < 7)
            return 2 // 2 code is password must be greater than 6
        else
            return -1 // -1 success
    }


    fun getEmail() = email

    fun getPassword() = password

    fun setEmail(email: String) {
        this.email = email
    }

    fun setPassword(password: String) {
        this.password = password
    }

}
