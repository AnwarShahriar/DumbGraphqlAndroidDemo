package me.anwarshahriaraits.androidgraphqldemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.anwarshahriaraits.androidgraphqldemo.model.FilmResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateFilmList()
    }

    private fun populateFilmList() {
        filmList.layoutManager = LinearLayoutManager(this)
        val adapter = FilmListAdapter()
        filmList.adapter = adapter
        loadFilms(adapter)
    }

    private fun loadFilms(adapter: FilmListAdapter) {
        FilmFetcher()
                .fetchFilm()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    if (it.isSuccessful) {
                        val json = it.body()?.string()
                        Gson().fromJson<FilmResponse>(json, FilmResponse::class.java)
                    } else null
                }
                .subscribe {
                    adapter.setFilms(it?.data?.films ?: listOf())
                }
    }
}
