package com.example.mvvmloginexample.Interface

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}