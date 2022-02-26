package com.example.exampleapp.domain.usecases.implementation

import com.example.exampleapp.domain.dto.User
import com.example.exampleapp.domain.repository.UserRepository
import com.example.exampleapp.domain.usecases.GetUsersUseCase

class GetUsersUseCaseImpl(
    private val userRepository: UserRepository
) : GetUsersUseCase {
    override suspend fun getUsers(): List<User> {
        return userRepository.getUsers()
    }
}