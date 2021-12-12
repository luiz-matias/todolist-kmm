package com.luizmatias.todoapp.di

import com.luizmatias.todoapp.data.repositories.AccountRepositoryImpl
import com.luizmatias.todoapp.data.repositories.AuthenticationRepositoryImpl
import com.luizmatias.todoapp.data.repositories.TaskManagementRepositoryImpl
import com.luizmatias.todoapp.data.repositories.TaskRepositoryImpl
import com.luizmatias.todoapp.domain.repositories.AccountRepository
import com.luizmatias.todoapp.domain.repositories.AuthenticationRepository
import com.luizmatias.todoapp.domain.repositories.TaskManagementRepository
import com.luizmatias.todoapp.domain.repositories.TaskRepository
import com.luizmatias.todoapp.domain.usecases.account.ChangePasswordUseCase
import com.luizmatias.todoapp.domain.usecases.account.EditProfileUseCase
import com.luizmatias.todoapp.domain.usecases.account.GetProfileUseCase
import com.luizmatias.todoapp.domain.usecases.authentication.LoginUseCase
import com.luizmatias.todoapp.domain.usecases.authentication.LogoutUseCase
import com.luizmatias.todoapp.domain.usecases.authentication.RecoverPasswordUseCase
import com.luizmatias.todoapp.domain.usecases.authentication.RegisterUseCase
import com.luizmatias.todoapp.domain.usecases.task.*
import com.luizmatias.todoapp.domain.usecases.taskmanagement.CompleteTaskUseCase
import com.luizmatias.todoapp.domain.usecases.taskmanagement.IncompleteTaskUseCase
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.Dispatchers
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS etc
fun initKoin() = initKoin {}

val commonModule = module {
    single { createHttpClient() }

    //Repositories
    single<AccountRepository> { AccountRepositoryImpl(get()) }
    single<AuthenticationRepository> { AuthenticationRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
    single<TaskManagementRepository> { TaskManagementRepositoryImpl(get()) }

    //Coroutines Dispatcher
    factory { Dispatchers.Default }

    //Account
    factory { ChangePasswordUseCase(get(), get()) }
    factory { EditProfileUseCase(get(), get()) }
    factory { GetProfileUseCase(get(), get()) }

    //Auth
    factory { LoginUseCase(get(), get()) }
    factory { LogoutUseCase(get(), get()) }
    factory { RecoverPasswordUseCase(get(), get()) }
    factory { RegisterUseCase(get(), get()) }

    //Task
    factory { DeleteTaskUseCase(get(), get()) }
    factory { EditTaskUseCase(get(), get()) }
    factory { GetTasksUseCase(get(), get()) }
    factory { GetTaskUseCase(get(), get()) }
    factory { RegisterTaskUseCase(get(), get()) }

    //Task Management
    factory { CompleteTaskUseCase(get(), get()) }
    factory { IncompleteTaskUseCase(get(), get()) }

}

fun createHttpClient() = HttpClient {
    expectSuccess = false
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }
}
