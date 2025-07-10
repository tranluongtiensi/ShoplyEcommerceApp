package com.example.shoplyecommerceapp.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.activities.AuthActivity

class LoginFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_main_page, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // xử lí khi ấn sign up trong giao diện login
        val signupBtnTv = view.findViewById<TextView>(R.id.signup_turnback_btn)
        signupBtnTv.setOnClickListener{
            (activity as? AuthActivity)?.switchToSignup()
        }

        // xử lí khi ấn btn login with email để hiện sheet dialog
        val loginEmail = view.findViewById<Button>(R.id.btn_login_email)
        loginEmail.setOnClickListener{
            LoginBottomSheet().show(requireActivity().supportFragmentManager, "loginTag")
        }
    }
}