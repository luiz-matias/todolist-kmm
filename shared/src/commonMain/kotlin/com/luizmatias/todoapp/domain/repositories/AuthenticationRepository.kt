package com.luizmatias.todoapp.domain.repositories

import com.luizmatias.todoapp.domain.entities.User

interface AuthenticationRepository {

    suspend fun login(email: String, password: String)
    suspend fun logout()
    suspend fun register(user: User, password: String)
    suspend fun recoverPassword(email: String)

}