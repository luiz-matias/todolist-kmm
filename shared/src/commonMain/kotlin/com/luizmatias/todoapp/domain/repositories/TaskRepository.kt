package com.luizmatias.todoapp.domain.repositories

import com.luizmatias.todoapp.domain.entities.Task

interface TaskRepository {

    suspend fun getTasks(): List<Task>
    suspend fun getTask(code: Int): Task
    suspend fun editTask(task: Task)
    suspend fun registerTask(task: Task)
    suspend fun deleteTask(task: Task)

}