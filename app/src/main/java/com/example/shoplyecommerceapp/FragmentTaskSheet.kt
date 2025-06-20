package com.example.shoplyecommerceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoplyecommerceapp.databinding.FragmentTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FragmentTaskSheet : BottomSheetDialogFragment() {
    private var _binding: FragmentTaskSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme
}