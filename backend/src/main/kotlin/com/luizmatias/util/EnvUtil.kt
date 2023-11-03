package com.luizmatias.util

import io.ktor.server.application.*

fun Application.isDevEnvironment(): Boolean {
    return environment.config.property("ktor.environment").getString() == "dev"
}