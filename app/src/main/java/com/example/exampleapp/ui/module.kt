package com.example.exampleapp.ui

import com.example.exampleapp.ui.activity_post_full.FullPostViewModel
import com.example.exampleapp.ui.mapper.*
import com.example.exampleapp.ui.post_comment.PostCommentsViewModel
import com.example.exampleapp.ui.activity_posts_list.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    factory<PostMapper> { PostMapperImpl() }
    factory<UserMapper> { UserMapperImpl() }
    factory<PostCommentMapper> { PostCommentMapperImpl() }
    viewModel { PostsViewModel(get(), get()) }
    viewModel { PostCommentsViewModel(get(), get()) }
    viewModel { FullPostViewModel(get(), get()) }

}