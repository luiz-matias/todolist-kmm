package com.luizmatias.todoapp.domain.repositories

import com.luizmatias.todoapp.domain.entities.Task

interface TaskManagementRepository {

    suspend fun completeTask(task: Task)
    suspend fun incompleteTask(task: Task)

}