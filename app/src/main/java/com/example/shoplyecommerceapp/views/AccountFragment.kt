package com.example.shoplyecommerceapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.example.shoplyecommerceapp.R


class AccountFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // xữ lí gender checkbox button
        val radioGroup = view.findViewById<RadioGroup>(R.id.gender_checkbox_ratiog)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.male_gender_checkbox -> {

                }
                R.id.female_gender_checkbox -> {

                }
                R.id.other_gender_checkbox -> {

                }
            }

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }
}