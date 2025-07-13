package com.example.shoplyecommerceapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplyecommerceapp.data.User
import com.example.shoplyecommerceapp.repository.AuthRepository
import com.example.shoplyecommerceapp.util.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authRepository: AuthRepository)
    : ViewModel(){
        private val _signup = MutableStateFlow<Resource<FirebaseUser>>(Resource.Unspecified())
        val signup : StateFlow<Resource<FirebaseUser>> = _signup

    fun CreateAccountWithEmail(user: User){
        viewModelScope.launch {
            _signup.emit(Resource.Loading())

            authRepository.createUser(user.Email, user.Password)
                .addOnSuccessListener{
                    it.user?.let{
                        _signup.value= Resource.Success(it)
                    }
                }
                .addOnFailureListener {
                    _signup.value= Resource.Error(it.message.toString())
                }
        }

    }
}