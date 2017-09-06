package me.anwarshahriaraits.androidgraphqldemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.anwarshahriaraits.androidgraphqldemo.model.Film

class FilmListAdapter: RecyclerView.Adapter<FilmViewHolder>() {

    private val films: MutableList<Film> = ArrayList()

    fun setFilms(films: List<Film>) {
        this.films.clear()
        this.films.addAll(films)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.film_item, parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder?, position: Int) {
        holder?.bind(films[position])
    }

    override fun getItemCount(): Int {
        return films.size
    }

}
