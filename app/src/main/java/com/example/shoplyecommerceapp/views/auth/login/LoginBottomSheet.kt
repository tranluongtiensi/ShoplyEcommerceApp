package com.example.shoplyecommerceapp.views.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.databinding.LoginBottomSheetBinding
import com.example.shoplyecommerceapp.viewmodels.LoginViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginBottomSheet : BottomSheetDialogFragment() {
    private var _binding: LoginBottomSheetBinding ?= null //nullable
    private val binding get() = _binding!! //non null

    private val viewModel by viewModels<LoginViewModel>() // delegate by viewModels của hilt sẽ tự động cung cấp view model có inject constructor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //gán listener cho view model
//        viewModel.authState = this
        //gán view model cho biding
        //xử lí button login click
        binding.btnLoginEmail.setOnClickListener{
            val email = binding.emailidEdt.text.toString()
            val password = binding.passwordEmailEdt.text.toString()
            viewModel.onLogin(email, password)
        }

        //hủy bottom sheet login
        binding.cancelLogin.setOnClickListener {
            dismiss()
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

//    override fun onStarted() {
//        Toast.makeText(context , "Login Started", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onSuccess() {
//        Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onFailure(message: String) {
//        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//    }
}