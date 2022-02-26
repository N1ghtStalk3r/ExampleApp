package com.example.exampleapp.data.repo

import com.example.exampleapp.data.mappers.UserResponseMapper
import com.example.exampleapp.data.net.user.UserApi
import com.example.exampleapp.domain.dto.User
import com.example.exampleapp.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userResponseMapper: UserResponseMapper
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userApi.getUsers()
            .map {
                userResponseMapper.userResponseToUser(it)
            }
    }
}