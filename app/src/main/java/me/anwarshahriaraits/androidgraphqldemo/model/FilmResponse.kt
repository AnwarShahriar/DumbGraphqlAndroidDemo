package me.anwarshahriaraits.androidgraphqldemo.model

import com.google.gson.annotations.SerializedName

data class FilmResponse(@SerializedName("data") val data: Data)

data class Data(@SerializedName("allFilms") val films: List<Film>)

data class Film(@SerializedName("title") val title: String,
                @SerializedName("director") val director: String)