package com.example.shoplyecommerceapp.views.auth.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.shoplyecommerceapp.R
import com.example.shoplyecommerceapp.data.User
import com.example.shoplyecommerceapp.databinding.LoginBottomSheetBinding

import com.example.shoplyecommerceapp.databinding.SignupBottomSheetBinding
import com.example.shoplyecommerceapp.util.Resource
import com.example.shoplyecommerceapp.viewmodels.SignupViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SignupBottomSheet : BottomSheetDialogFragment() {
    private var _binding: SignupBottomSheetBinding ?= null //nullable
    private val binding get() = _binding!! //non null

    private val viewModel: SignupViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignupBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelSignup.setOnClickListener {
            dismiss()
        }
        binding.apply { //apply có tác dụng để mà không cần ghi lại binding khi gọi tới các view
            btnSignupEmail.setOnClickListener {
                val user = User(
                    emailidSignupEdt.text.toString().trim(),
                    pwEmailSignupEdt.text.toString().trim(),
                    confirmPwSignupEdt.text.toString().trim()
                )
                viewModel.CreateAccountWithEmail(user)
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle (Lifecycle.State.STARTED){
                viewModel.signup.collect { state ->
                    when(state){
                        is Resource.Loading ->{

                        }
                        is Resource.Success ->{
                            Log.d("test", state.data.toString())
                        }
                        is Resource.Error -> {
                            Log.d("TAG", state.message.toString())
                        }
                        else -> Unit
                    }
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme
}