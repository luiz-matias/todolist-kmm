package com.luizmatias.todoapp.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Method that makes coroutine calls exception-safe
 * @param dispatcher Dispatcher that would be used to run the coroutine (Dispatchers.IO by default)
 * @param block function that will be executed inside the coroutine
 * @return Result containing a success case or a failure case
 */
suspend fun <T> resultHandler(
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    block: suspend () -> (T)
) = withContext(dispatcher) {
    return@withContext try {
        val result = block()
        Result.Success(result)
    } catch (ex: Exception) {
        Result.Failure(ex)
    }
}

sealed class Result<out T> {
    class Success<T>(val data: T) : Result<T>()
    class Failure(val error: Exception) : Result<Nothing>()
}