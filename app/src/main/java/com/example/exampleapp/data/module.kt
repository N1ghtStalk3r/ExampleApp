package com.example.exampleapp.data

import com.example.exampleapp.data.mappers.*
import com.example.exampleapp.data.net.HttpClientProvider
import com.example.exampleapp.data.net.post.PostApi
import com.example.exampleapp.data.net.post.PostApiImpl
import com.example.exampleapp.data.net.post_comment.PostCommentApi
import com.example.exampleapp.data.net.post_comment.PostCommentApiImpl
import com.example.exampleapp.data.net.user.UserApi
import com.example.exampleapp.data.net.user.UserApiImpl
import com.example.exampleapp.data.repo.PostCommentRepositoryImpl
import com.example.exampleapp.data.repo.PostRepositoryImpl
import com.example.exampleapp.data.repo.UserRepositoryImpl
import com.example.exampleapp.domain.repository.PostCommentRepository
import com.example.exampleapp.domain.repository.PostRepository
import com.example.exampleapp.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single { ConstantsProvider() }
    single { HttpClientProvider(get()) }

    // Посты
    factory<PostApi> { PostApiImpl(get()) }
    factory<PostResponseMapper> { PostResponseMapperImpl() }
    factory<PostRepository> { PostRepositoryImpl(get(), get()) }

    // Комментарии к постам?
    factory<PostCommentApi> { PostCommentApiImpl(get()) }
    factory<PostCommentResponseMapper> { PostCommentResponseMapperImpl() }
    factory<PostCommentRepository> { PostCommentRepositoryImpl(get(), get()) }

    // Пользователи
    factory<UserApi> {  UserApiImpl(get())}
    factory<UserResponseMapper> {UserResponseMapperImpl()  }
    factory<UserRepository> {  UserRepositoryImpl(get(), get())}
}