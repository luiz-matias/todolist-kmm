package com.luizmatias.di

import com.luizmatias.config.connectToDatabase
import com.luizmatias.services.UserService
import io.ktor.server.application.*
import org.koin.dsl.module

fun appModule(application: Application) = module {
    factory { application.connectToDatabase() }
    single { UserService(get()) }
}