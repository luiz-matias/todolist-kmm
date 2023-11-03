package com.luizmatias

import com.luizmatias.config.*
import com.luizmatias.di.appModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    //Dependency Injection
    install(Koin) {
        slf4jLogger()
        modules(appModule(this@module))
    }
    //Json
    configureSerialization()
    //Logging request calls
    configureMonitoring()
    //Default headers and CORS
    configureHTTP()
    //JWT Auth
    configureSecurity()
    //Status pages
    configureStatusPages()
    //Routes
    configureRouting()
}
