package com.luizmatias.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessageDTO(
    val status: Int,
    val message: String,
    val stackTrace: String? = null,
)
