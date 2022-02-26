package com.example.exampleapp.domain.usecases

import com.example.exampleapp.domain.dto.Post


interface GetPostsUseCase {
    suspend fun getPosts():List<Post>
}