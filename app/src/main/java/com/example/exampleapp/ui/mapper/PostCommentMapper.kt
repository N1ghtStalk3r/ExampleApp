package com.example.exampleapp.ui.mapper

import com.example.exampleapp.domain.dto.PostComment
import com.example.exampleapp.ui.dto.PostCommentItem

interface PostCommentMapper  {
    fun postCommentToPostCommentItem (postComment: PostComment): PostCommentItem
}

class PostCommentMapperImpl: PostCommentMapper {
    override fun postCommentToPostCommentItem(postComment: PostComment): PostCommentItem {
        return PostCommentItem(
            postComment.id,
            postComment.postId,
            postComment.name,
            postComment.email,
            postComment.body
        )
    }
}