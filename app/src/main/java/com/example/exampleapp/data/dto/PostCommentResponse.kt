package com.example.exampleapp.data.dto

// Ответ по сервера
data class PostCommentResponse(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)