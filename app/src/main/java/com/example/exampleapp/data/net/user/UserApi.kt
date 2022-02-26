package com.example.exampleapp.data.net.user

import com.example.exampleapp.data.dto.UserResponse

interface UserApi {
    suspend fun getUsers() : List<UserResponse>
}