package com.luizmatias.todoapp.domain.usecases.task

import com.luizmatias.todoapp.domain.repositories.TaskRepository
import com.luizmatias.todoapp.utils.resultHandler
import kotlinx.coroutines.CoroutineDispatcher

class DeleteTaskUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val taskRepository: TaskRepository
) {

    suspend operator fun invoke() = resultHandler(coroutineDispatcher) {
        taskRepository.getTasks()
    }

}