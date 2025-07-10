package com.example.shoplyecommerceapp.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoplyecommerceapp.R

import com.example.shoplyecommerceapp.databinding.SignupBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SignupBottomSheet : BottomSheetDialogFragment() {
    private var _binding: SignupBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignupBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelSignup.setOnClickListener {
            dismiss()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme
}