package com.example.exampleapp.data.dto

// Ответ по сервера
data class UserResponse(
    val id: Int,
    val name: String,
    val userName: String,
    val email: String
)