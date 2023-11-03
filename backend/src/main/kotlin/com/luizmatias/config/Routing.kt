package com.luizmatias.config

import com.luizmatias.dtos.ErrorMessageDTO
import com.luizmatias.routes.userRoutes
import com.luizmatias.util.isDevEnvironment
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    userRoutes()
}

fun Application.configureStatusPages() {
    val isDevEnvironment = isDevEnvironment()

    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respond(
                status = HttpStatusCode.InternalServerError,
                message = ErrorMessageDTO(
                    status = 500,
                    message = if (isDevEnvironment) cause.toString() else "Internal server error",
                    stackTrace = if (isDevEnvironment) cause.stackTraceToString() else null,
                ),
            )
        }
    }
}
