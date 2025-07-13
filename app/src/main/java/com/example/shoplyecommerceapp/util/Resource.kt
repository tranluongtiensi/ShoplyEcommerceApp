package com.example.shoplyecommerceapp.util

sealed class Resource<T> (
    val data: T ?= null,
    val message: String ?= null
){
    class Success<T>(data: T): Resource<T>(data)  //class A(arg): B(arg)	: là kế thừa và gọi constructor lớp cha
    class Error<T>(message: String): Resource<T>(message = message) //data của success truyển ngược lên resource để resource hoạt động
                                            // vì khi tạo class success hay error thì cũng đang tạo luôn resource
    class Loading<T>: Resource<T>()
    class Unspecified<T>: Resource<T>()
}