package com.example.exampleapp.data.mappers

import com.example.exampleapp.data.dto.UserResponse
import com.example.exampleapp.domain.dto.User

interface UserResponseMapper {
    fun userResponseToUser(userResponse: UserResponse): User
}

class UserResponseMapperImpl : UserResponseMapper {
    override fun userResponseToUser(userResponse: UserResponse): User {
        return User(
            userResponse.id,
            userResponse.name,
            userResponse.userName,
            userResponse.email
        )
    }
}