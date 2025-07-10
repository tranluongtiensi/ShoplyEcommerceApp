package com.example.shoplyecommerceapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.fragments.login.LoginFragment
import com.example.shoplyecommerceapp.fragments.signup.SignupFragment

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // mặc định hiển thi login fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_container, LoginFragment())
            .commit()

        val showSignup = intent.getBooleanExtra("SHOW_SIGNUP", false)

        if(savedInstanceState == null){
            val fragment = if(showSignup) SignupFragment() else LoginFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.auth_container, fragment)
                .commit()
        }
        // hàm chuyển qua lại giửa fragment

    }
    fun switchToSignup(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_container, SignupFragment())
            .addToBackStack(null)
            .commit()
    }
    fun switchToLogin(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_container, LoginFragment())
            .addToBackStack(null)
            .commit()
    }
}