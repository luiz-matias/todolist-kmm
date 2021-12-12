package com.luizmatias.todoapp.domain.entities

data class Task(
    val code: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val creationDate: String
)