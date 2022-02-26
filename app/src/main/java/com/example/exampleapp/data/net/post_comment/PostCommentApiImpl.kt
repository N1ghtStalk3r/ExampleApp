package com.example.exampleapp.data.net.post_comment

import com.example.exampleapp.data.dto.PostCommentResponse
import com.example.exampleapp.data.net.HttpClientProvider
import io.ktor.client.request.*

class PostCommentApiImpl(
    private val client: HttpClientProvider
): PostCommentApi {
    override suspend fun getPostComments(): List<PostCommentResponse> {
        return client.getHttpClient().get("comments")
    }
}