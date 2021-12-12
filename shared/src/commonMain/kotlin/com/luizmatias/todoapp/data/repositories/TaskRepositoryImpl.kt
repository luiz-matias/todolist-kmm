package com.luizmatias.todoapp.data.repositories

import com.luizmatias.todoapp.data.remote.ApiConstants
import com.luizmatias.todoapp.domain.entities.Task
import com.luizmatias.todoapp.domain.repositories.TaskRepository
import io.ktor.client.*
import io.ktor.client.request.*

class TaskRepositoryImpl(private val httpClient: HttpClient) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return httpClient.get(ApiConstants.BASEURL + "/task")
    }

    override suspend fun getTask(code: Int): Task {
        return httpClient.get(ApiConstants.BASEURL + "/task/$code")
    }

    override suspend fun editTask(task: Task) {
        return httpClient.put(ApiConstants.BASEURL + "/task/${task.code}") {
            body = task
        }
    }

    override suspend fun registerTask(task: Task) {
        return httpClient.post(ApiConstants.BASEURL + "/task") {
            body = task
        }
    }

    override suspend fun deleteTask(task: Task) {
        return httpClient.delete(ApiConstants.BASEURL + "/task/${task.code}")
    }

}