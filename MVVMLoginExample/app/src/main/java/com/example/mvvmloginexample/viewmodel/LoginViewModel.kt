package com.example.mvvmloginexample.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmloginexample.Interface.LoginResultCallBacks
import com.example.mvvmloginexample.model.User

class LoginViewModel (private val listener:LoginResultCallBacks): ViewModel() {
    private val user: User

    init {
        this.user = User("","")
    }

    // create function to set Email after user finish enter text
    val emailTextWatcher:TextWatcher
        get() = object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(p0: Editable?) {
            user.setEmail(p0.toString())
        }
    }

    // create function to set Password after user finish enter text
    val passwordTextWatcher:TextWatcher
        get() = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                user.setPassword(p0.toString())
            }
        }

    // create function to process login button clicked
    fun onLoginClicked(v: View) {
        val loginCode:Int = user.isDataValid()
        if(loginCode == 0)
            listener.onError("Email must not be null")

        else if (loginCode == 1)
            listener.onError("Wrong Email Pattern")

        else if (loginCode == 2)
            listener.onError("Password length must greater than 6")
        else
            listener.onSuccess("Login Success")
    }
}