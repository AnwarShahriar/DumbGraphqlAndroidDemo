package me.anwarshahriaraits.androidgraphqldemo

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.film_item.view.*
import me.anwarshahriaraits.androidgraphqldemo.model.Film

class FilmViewHolder(view: View): RecyclerView.ViewHolder(view), DataBinder<Film> {

    override fun bind(data: Film) {
        itemView.title.text = data.title
        itemView.director.text = data.director
    }

}
