package com.example.exampleapp.data.net.post

import com.example.exampleapp.data.dto.PostResponse
import com.example.exampleapp.data.net.HttpClientProvider
import io.ktor.client.request.*

class PostApiImpl(
    private val client: HttpClientProvider
) : PostApi {
    override suspend fun getPosts(): List<PostResponse> {
        return client.getHttpClient().get("posts")
    }
}