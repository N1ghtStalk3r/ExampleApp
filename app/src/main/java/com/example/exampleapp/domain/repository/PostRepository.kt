package com.example.exampleapp.domain.repository

import com.example.exampleapp.domain.dto.Post

interface PostRepository {
    suspend fun getPosts():List<Post>
}