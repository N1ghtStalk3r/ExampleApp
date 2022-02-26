package com.example.exampleapp.data.repo


import com.example.exampleapp.data.mappers.PostResponseMapper
import com.example.exampleapp.data.net.post.PostApi
import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.repository.PostRepository

class PostRepositoryImpl(
    private val postApi: PostApi,
    private val postResponseMapper: PostResponseMapper
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        //get data
        //save to db
        // return data from db
        return postApi.getPosts().map { postResponseMapper.postResponseToPost(it) }
    }
}