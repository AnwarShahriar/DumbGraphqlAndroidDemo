package me.anwarshahriaraits.androidgraphqldemo

import io.reactivex.Observable
import okhttp3.*

class FilmFetcher {
    fun fetchFilm(): Observable<Response> {
        return Observable.fromCallable {
            val request = Request.Builder()
                    .url("https://api.graph.cool/simple/v1/cj79lg0v10dzt0151l7n7byug")
                    .post(RequestBody.create(MediaType.parse("application/json"), "{ \"query\": \"{ allFilms { title director } }\"}"))
                    .build()
            OkHttpClient().newCall(request).execute()
        }
    }
}