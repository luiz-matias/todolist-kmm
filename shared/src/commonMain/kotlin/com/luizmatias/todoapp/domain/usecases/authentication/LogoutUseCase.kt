package com.luizmatias.todoapp.domain.usecases.authentication

import com.luizmatias.todoapp.domain.repositories.AuthenticationRepository
import com.luizmatias.todoapp.utils.resultHandler
import kotlinx.coroutines.CoroutineDispatcher

class LogoutUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val authenticationRepository: AuthenticationRepository
) {

    suspend operator fun invoke() = resultHandler(coroutineDispatcher) {
        authenticationRepository.logout()
    }

}