package com.luizmatias.todoapp.domain.repositories

import com.luizmatias.todoapp.domain.entities.User

interface AuthenticationRepository {

    suspend fun login(email: String, password: String): User
    suspend fun logout()
    suspend fun register(user: User, password: String): User
    suspend fun recoverPassword(email: String)

}