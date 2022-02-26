package com.example.exampleapp.data.net.post

import com.example.exampleapp.data.dto.PostResponse

interface PostApi {
    suspend fun getPosts(): List<PostResponse>
}