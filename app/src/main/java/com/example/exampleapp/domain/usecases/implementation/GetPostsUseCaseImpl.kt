package com.example.exampleapp.domain.usecases.implementation

import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.repository.PostRepository
import com.example.exampleapp.domain.usecases.GetPostsUseCase

class GetPostsUseCaseImpl(
    private val postRepository: PostRepository
): GetPostsUseCase {
    override suspend fun getPosts(): List<Post> {
        return postRepository.getPosts()
    }
}