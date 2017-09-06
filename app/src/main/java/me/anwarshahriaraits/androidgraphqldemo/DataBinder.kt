package me.anwarshahriaraits.androidgraphqldemo

interface DataBinder<in T> {
    fun bind(data: T)
}
