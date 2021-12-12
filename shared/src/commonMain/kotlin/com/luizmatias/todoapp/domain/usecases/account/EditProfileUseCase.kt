package com.luizmatias.todoapp.domain.usecases.account

import com.luizmatias.todoapp.domain.entities.User
import com.luizmatias.todoapp.domain.repositories.AccountRepository
import com.luizmatias.todoapp.utils.resultHandler
import kotlinx.coroutines.CoroutineDispatcher

class EditProfileUseCase(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val accountRepository: AccountRepository
) {

    suspend operator fun invoke(newUser: User) = resultHandler(coroutineDispatcher) {
        accountRepository.editProfile(newUser)
    }

}