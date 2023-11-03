package com.luizmatias.models

import org.jetbrains.exposed.sql.Table

object UsersTable : Table(name = "users") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", length = 100)
    val age = integer("age")

    override val primaryKey = PrimaryKey(id)
}