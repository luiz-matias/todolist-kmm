package com.luizmatias.todoapp.domain.usecases.authentication

import com.luizmatias.todoapp.domain.entities.User
import com.luizmatias.todoapp.domain.repositories.AuthenticationRepository
import com.luizmatias.todoapp.utils.resultHandler
import kotlinx.coroutines.CoroutineDispatcher

class RegisterUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val authenticationRepository: AuthenticationRepository
) {

    suspend operator fun invoke(user: User, password: String) =
        resultHandler(coroutineDispatcher) {
            authenticationRepository.register(user, password)
        }

}