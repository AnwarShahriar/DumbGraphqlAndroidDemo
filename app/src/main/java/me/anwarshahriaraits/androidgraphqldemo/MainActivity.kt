package me.anwarshahriaraits.androidgraphqldemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.anwarshahriaraits.androidgraphqldemo.model.Film

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateFilmList()
    }

    private fun populateFilmList() {
        filmList.layoutManager = LinearLayoutManager(this)
        val adapter = FilmListAdapter()
        adapter.setFilms(mockFilms())
        filmList.adapter = adapter
    }

    private fun mockFilms(): List<Film> {
        return listOf(
                Film("Harry Potter 1", "Chris Columbus"),
                Film("Harry Potter 2", "Chris Columbus"),
                Film("Harry Potter 3", "Chris Columbus")
        )
    }

}
