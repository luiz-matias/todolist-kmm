package com.luizmatias.todoapp.data.remote.models

import com.luizmatias.todoapp.domain.entities.User

data class RegisterRequest(
    val user: User,
    val password: String
)