package com.luizmatias.todoapp.domain.usecases.account

import com.luizmatias.todoapp.domain.repositories.AccountRepository
import com.luizmatias.todoapp.utils.resultHandler
import kotlinx.coroutines.CoroutineDispatcher

class ChangePasswordUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(newPassword: String) = resultHandler(coroutineDispatcher) {
        accountRepository.changePassword(newPassword)
    }

}