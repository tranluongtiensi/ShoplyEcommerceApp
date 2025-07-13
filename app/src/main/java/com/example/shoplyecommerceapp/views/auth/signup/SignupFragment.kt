package com.example.shoplyecommerceapp.views.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.activities.AuthActivity

class SignupFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.signup_main_page, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signupBtnTv = view.findViewById<TextView>(R.id.login_turnback_btn)
        signupBtnTv.setOnClickListener{
            (activity as? AuthActivity)?.switchToLogin()
        }

        //xử lí khi ấn vào sign up with email hiện le bottom dialog
        val signupEmail = view.findViewById<Button>(R.id.btn_signup_email)
        signupEmail.setOnClickListener{
            SignupBottomSheet().show(requireActivity().supportFragmentManager, "signupTag")
        }
    }
}