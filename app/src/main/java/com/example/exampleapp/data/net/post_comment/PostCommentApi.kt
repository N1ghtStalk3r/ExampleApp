package com.example.exampleapp.data.net.post_comment

import com.example.exampleapp.data.dto.PostCommentResponse

interface PostCommentApi {
    suspend fun getPostComments(): List<PostCommentResponse>
}