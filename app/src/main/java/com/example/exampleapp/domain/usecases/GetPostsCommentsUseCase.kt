package com.example.exampleapp.domain.usecases

import com.example.exampleapp.domain.dto.PostComment

interface GetPostsCommentsUseCase {
    suspend fun getPostsComments(): List<PostComment>
}