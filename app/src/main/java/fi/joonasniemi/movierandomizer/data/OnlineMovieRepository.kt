package fi.joonasniemi.movierandomizer.data

import fi.joonasniemi.movierandomizer.BuildConfig
import io.ktor.client.request.*
import io.ktor.client.statement.*

object OnlineMovieRepository {
    private const val BASE_URL = "http://www.omdbapi.com/?apikey=${BuildConfig.OMDB_API}"
    private val ktor = Ktor.client

    suspend fun getMovieByTitle(title: String): HttpResponse {
        return ktor.use {
            it.get("$BASE_URL&t=$title")
        }
    }
}