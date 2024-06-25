package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun<T,R> Flow<List<T>>.mapList(transform: (T) -> R): Flow<List<R>> {
    return this.map { list -> list.map { transform(it) } }
}


suspend fun<T> safeApiCall(call: suspend () -> T): T  {
    return try {
        call()
    } catch (e: Exception) {
        e.printStackTrace()
        throw e
    }
}