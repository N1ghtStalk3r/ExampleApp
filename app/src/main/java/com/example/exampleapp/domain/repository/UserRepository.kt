package com.example.exampleapp.domain.repository

import com.example.exampleapp.domain.dto.User

interface UserRepository {
    suspend fun getUsers() : List<User>
}