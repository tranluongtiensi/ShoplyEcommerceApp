package com.example.shoplyecommerceapp.data

data class Footwear (
    val  image: Int,
    var isFavorite: Boolean = false,
    val name: String,
    val price: String,
    val ratelevel: String,
    val ratequantity: String
)