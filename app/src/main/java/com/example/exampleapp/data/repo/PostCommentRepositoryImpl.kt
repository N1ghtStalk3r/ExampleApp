package com.example.exampleapp.data.repo

import com.example.exampleapp.data.mappers.PostCommentResponseMapper
import com.example.exampleapp.data.net.post_comment.PostCommentApi
import com.example.exampleapp.domain.dto.PostComment
import com.example.exampleapp.domain.repository.PostCommentRepository

class PostCommentRepositoryImpl(
    private val postCommentApi: PostCommentApi,
    private val postCommentResponseMapper: PostCommentResponseMapper
) : PostCommentRepository {
    override suspend fun getPostComments(): List<PostComment> {
        return postCommentApi.getPostComments().map {
            postCommentResponseMapper.postCommentResponseToPostComment(it)
        }
    }
}