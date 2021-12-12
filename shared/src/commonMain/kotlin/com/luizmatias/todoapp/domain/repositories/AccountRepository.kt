package com.luizmatias.todoapp.domain.repositories

import com.luizmatias.todoapp.domain.entities.User

interface AccountRepository {

    suspend fun getProfile(): User
    suspend fun editProfile(newUser: User)
    suspend fun logout()
    suspend fun changePassword(newPassword: String)

}