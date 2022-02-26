package com.example.exampleapp.ui.mapper

import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.ui.dto.PostListItem

interface PostMapper{
    fun postToPostListItem(post:Post):PostListItem
}

class PostMapperImpl:PostMapper{
    override fun postToPostListItem(post: Post): PostListItem {
        return PostListItem(post.id, post.title)
    }
}