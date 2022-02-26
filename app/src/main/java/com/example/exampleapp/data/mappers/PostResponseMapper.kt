package com.example.exampleapp.data.mappers

import com.example.exampleapp.data.dto.PostResponse
import com.example.exampleapp.domain.dto.Post

interface PostResponseMapper {
    fun postResponseToPost(postResponse: PostResponse): Post
}

class PostResponseMapperImpl : PostResponseMapper {
    override fun postResponseToPost(postResponse: PostResponse): Post {
        return Post(
            postResponse.id,
            postResponse.userId,
            postResponse.title,
            postResponse.body
        )
    }
}