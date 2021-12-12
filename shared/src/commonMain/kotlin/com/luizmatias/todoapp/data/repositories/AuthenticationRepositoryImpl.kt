package com.luizmatias.todoapp.data.repositories

import com.luizmatias.todoapp.data.remote.ApiConstants
import com.luizmatias.todoapp.data.remote.models.LoginRequest
import com.luizmatias.todoapp.data.remote.models.RecoverPasswordRequest
import com.luizmatias.todoapp.data.remote.models.RegisterRequest
import com.luizmatias.todoapp.domain.entities.User
import com.luizmatias.todoapp.domain.repositories.AuthenticationRepository
import io.ktor.client.*
import io.ktor.client.request.*

class AuthenticationRepositoryImpl(private val httpClient: HttpClient) : AuthenticationRepository {

    override suspend fun login(email: String, password: String): User {
        return httpClient.post(ApiConstants.BASEURL + "/auth/login") {
            body = LoginRequest(email, password)
        }
    }

    override suspend fun logout() {
        return httpClient.post(ApiConstants.BASEURL + "/auth/logout")
    }

    override suspend fun register(user: User, password: String): User {
        return httpClient.post(ApiConstants.BASEURL + "/auth/register") {
            body = RegisterRequest(user, password)
        }
    }

    override suspend fun recoverPassword(email: String) {
        return httpClient.post(ApiConstants.BASEURL + "/auth/recoverpassword") {
            body = RecoverPasswordRequest(email)
        }
    }
}