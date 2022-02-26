package com.example.exampleapp.domain

import com.example.exampleapp.domain.usecases.GetPostsCommentsUseCase
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.domain.usecases.implementation.GetPostsCommentsUseCaseImpl
import com.example.exampleapp.domain.usecases.implementation.GetPostsUseCaseImpl
import org.koin.dsl.module

val domain = module {
    // Посты
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }

    // Комментарии к постам?
    factory<GetPostsCommentsUseCase> { GetPostsCommentsUseCaseImpl(get()) }
}