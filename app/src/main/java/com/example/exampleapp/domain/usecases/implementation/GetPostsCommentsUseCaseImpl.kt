package com.example.exampleapp.domain.usecases.implementation

import com.example.exampleapp.domain.dto.PostComment
import com.example.exampleapp.domain.repository.PostCommentRepository
import com.example.exampleapp.domain.usecases.GetPostsCommentsUseCase

class GetPostsCommentsUseCaseImpl(
    private val postCommentsRepository: PostCommentRepository
): GetPostsCommentsUseCase {
    override suspend fun getPostsComments(): List<PostComment> {
        return postCommentsRepository.getPostComments()
    }
}