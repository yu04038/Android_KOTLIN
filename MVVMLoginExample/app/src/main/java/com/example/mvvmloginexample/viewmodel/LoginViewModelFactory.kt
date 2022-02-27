package com.example.mvvmloginexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmloginexample.Interface.LoginResultCallBacks

// ViewModelFactory 는 viewmodel을 통해 전달되는 인자가 있을 때 사용된다.
// 어떤 인자를 생성자에 전달할지 viewModelProvider 에게 알려주어야 한다.
class LoginViewModelFactory(private val listener:LoginResultCallBacks):ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}