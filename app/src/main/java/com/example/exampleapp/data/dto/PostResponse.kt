package com.example.exampleapp.data.dto

// Ответ по сервера
data class PostResponse(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
