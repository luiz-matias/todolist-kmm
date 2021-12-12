package com.luizmatias.todoapp.data.repositories

import com.luizmatias.todoapp.data.remote.ApiConstants
import com.luizmatias.todoapp.domain.entities.Task
import com.luizmatias.todoapp.domain.repositories.TaskManagementRepository
import io.ktor.client.*
import io.ktor.client.request.*

class TaskManagementRepositoryImpl(private val httpClient: HttpClient) : TaskManagementRepository {

    override suspend fun completeTask(task: Task) {
        return httpClient.post(ApiConstants.BASEURL + "/task/${task.code}/complete")
    }

    override suspend fun incompleteTask(task: Task) {
        return httpClient.post(ApiConstants.BASEURL + "/task/${task.code}/incomplete")
    }

}