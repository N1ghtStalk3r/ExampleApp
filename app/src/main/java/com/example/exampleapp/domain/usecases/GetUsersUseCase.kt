package com.example.exampleapp.domain.usecases

import com.example.exampleapp.domain.dto.User

interface GetUsersUseCase {
    suspend fun getUsers(): List<User>
}