package com.luizmatias.config

import com.luizmatias.util.isDevEnvironment
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.connectToDatabase(): Database {
    return if (isDevEnvironment()) {
        Database.connect(
            url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
            user = "root",
            driver = "org.h2.Driver",
            password = ""
        )
    } else {
        val driver = environment.config.property("database.driver").getString()
        val url = environment.config.property("database.url").getString()
        val user = environment.config.property("database.user").getString()
        val password = environment.config.property("database.password").getString()

        Database.connect(
            createHikariDataSource(
                url = url,
                driver = driver,
                user = user,
                password = password
            )
        )
    }
}

private fun createHikariDataSource(
    driver: String,
    url: String,
    user: String,
    password: String
) = HikariDataSource(HikariConfig().apply {
    driverClassName = driver
    jdbcUrl = url
    username = user
    setPassword(password)
    maximumPoolSize = 3
    isAutoCommit = false
    transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    validate()
})