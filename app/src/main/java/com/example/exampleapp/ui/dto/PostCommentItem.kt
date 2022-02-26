package com.example.exampleapp.ui.dto

data class PostCommentItem(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)
