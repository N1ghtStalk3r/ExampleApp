package com.example.exampleapp.domain.dto

// Для программы
data class PostComment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)