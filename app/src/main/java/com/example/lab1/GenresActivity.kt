package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_genres.*
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.activity_movie_list.*

class GenresActivity : AppCompatActivity(), ItemClick {

    override fun onItemClick(pos: Int) {
        val genreName = movieGenres[pos]

        val intent = Intent(this, MovieListActivity::class.java)
        intent.putExtra("genre", genreName)
        startActivity(intent)
    }

    val movieGenres: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres)
        addGenres()
        genresRecyclerView.layoutManager = LinearLayoutManager(this)
        genresRecyclerView.adapter = GenresAdapter(movieGenres, this)

    }

    fun addGenres() {
        movieGenres.add("Жанр 1")
        movieGenres.add("Жанр 2")
        movieGenres.add("Жанр 3")
        movieGenres.add("Жанр 4")
    }
}
