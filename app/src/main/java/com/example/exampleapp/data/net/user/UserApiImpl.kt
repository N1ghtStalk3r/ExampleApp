package com.example.exampleapp.data.net.user

import com.example.exampleapp.data.dto.UserResponse
import com.example.exampleapp.data.net.HttpClientProvider
import io.ktor.client.request.*

class UserApiImpl(
    private val client: HttpClientProvider
) : UserApi {
    override suspend fun getUsers(): List<UserResponse> {
        return client.getHttpClient().get("users")
    }
}