package com.luizmatias.todoapp.domain.usecases.authentication

import com.luizmatias.todoapp.domain.repositories.AuthenticationRepository
import com.luizmatias.todoapp.utils.resultHandler
import kotlinx.coroutines.CoroutineDispatcher

class RecoverPasswordUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val authenticationRepository: AuthenticationRepository
) {

    suspend operator fun invoke(email: String) = resultHandler(coroutineDispatcher) {
        authenticationRepository.recoverPassword(email)
    }

}