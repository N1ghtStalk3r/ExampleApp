package com.example.exampleapp.ui.mapper

import com.example.exampleapp.domain.dto.User
import com.example.exampleapp.ui.dto.UserItem

interface UserMapper {
    fun userToUserItem( user: User): UserItem
}

class UserMapperImpl: UserMapper {
    override fun userToUserItem(user: User): UserItem {
        return UserItem(user.name, user.email)
    }
}
