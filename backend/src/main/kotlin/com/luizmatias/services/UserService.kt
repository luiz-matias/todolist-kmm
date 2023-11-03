package com.luizmatias.services

import com.luizmatias.models.User
import com.luizmatias.models.UsersTable
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class UserService(private val database: Database) {

    init {
        transaction(database) {
            SchemaUtils.create(UsersTable)
        }
    }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO, database) { block() }

    suspend fun create(user: User): Int {
        return dbQuery {
            UsersTable.insert {
                it[name] = user.name
                it[age] = user.age
            }[UsersTable.id]
        }
    }

    suspend fun read(id: Int): User? {
        return dbQuery {
            UsersTable.select { UsersTable.id eq id }
                .map { User(it[UsersTable.name], it[UsersTable.age]) }
                .singleOrNull()
        }
    }

    suspend fun update(id: Int, user: User) {
        dbQuery {
            UsersTable.update({ UsersTable.id eq id }) {
                it[name] = user.name
                it[age] = user.age
            }
        }
    }

    suspend fun delete(id: Int) {
        dbQuery {
            UsersTable.deleteWhere { UsersTable.id.eq(id) }
        }
    }
}