package com.example.exampleapp.data.mappers

import com.example.exampleapp.data.dto.PostCommentResponse
import com.example.exampleapp.domain.dto.PostComment

interface PostCommentResponseMapper {
    fun postCommentResponseToPostComment(
        postCommentResponse: PostCommentResponse
    ): PostComment
}
class PostCommentResponseMapperImpl: PostCommentResponseMapper {
    override fun postCommentResponseToPostComment(postCommentResponse: PostCommentResponse): PostComment {
        return PostComment(
            postCommentResponse.body,
            postCommentResponse.email,
            postCommentResponse.id,
            postCommentResponse.name,
            postCommentResponse.postId
        )
    }
}