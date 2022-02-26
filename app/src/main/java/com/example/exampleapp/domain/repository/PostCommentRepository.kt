package com.example.exampleapp.domain.repository

import com.example.exampleapp.domain.dto.PostComment

interface PostCommentRepository {
    suspend fun getPostComments(): List<PostComment>
}