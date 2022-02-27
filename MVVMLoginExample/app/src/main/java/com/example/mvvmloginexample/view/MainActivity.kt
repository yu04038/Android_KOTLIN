package com.example.mvvmloginexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmloginexample.R
import com.example.mvvmloginexample.Interface.LoginResultCallBacks
import com.example.mvvmloginexample.databinding.ActivityMainBinding
import com.example.mvvmloginexample.viewmodel.LoginViewModel
import com.example.mvvmloginexample.viewmodel.LoginViewModelFactory
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProvider(this, LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT)
            .show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT)
            .show()
    }
}