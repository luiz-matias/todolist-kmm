package com.luizmatias.todoapp.data.repositories

import com.luizmatias.todoapp.data.remote.ApiConstants
import com.luizmatias.todoapp.data.remote.models.PasswordRequest
import com.luizmatias.todoapp.domain.entities.User
import com.luizmatias.todoapp.domain.repositories.AccountRepository
import io.ktor.client.*
import io.ktor.client.request.*

class AccountRepositoryImpl(private val httpClient: HttpClient) : AccountRepository {

    override suspend fun getProfile(): User {
        return httpClient.get(ApiConstants.BASEURL + "/account")
    }

    override suspend fun editProfile(newUser: User) {
        return httpClient.put(ApiConstants.BASEURL + "/account") {
            body = newUser
        }
    }

    override suspend fun logout() {
        httpClient.post<String>(ApiConstants.BASEURL + "/account/logout")
    }

    override suspend fun changePassword(newPassword: String) {
        httpClient.post<String>(ApiConstants.BASEURL + "/account/changepassword") {
            body = PasswordRequest(newPassword)
        }
    }

}