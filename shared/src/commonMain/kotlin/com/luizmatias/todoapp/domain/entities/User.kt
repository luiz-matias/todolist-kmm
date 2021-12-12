package com.luizmatias.todoapp.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val firstName: String,
    val lastName: String,
    val email: String
)