package com.luizmatias.todoapp.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class PasswordRequest(
    val newPassword: String
)