package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_genres.*

class AuthorsActivity : AppCompatActivity(), ItemClick {

    override fun onItemClick(pos: Int) {
        val genreName = movieGenres[pos]
        val intent = Intent(this, ComixListActivity::class.java)
        intent.putExtra("genre", genreName)
        startActivity(intent)
    }

    val movieGenres: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres)
        addGenres()
        genresRecyclerView.layoutManager = LinearLayoutManager(this)
        genresRecyclerView.adapter = AuthorsAdapter(movieGenres, this, this)

    }

    fun addGenres() {
        movieGenres.add("Стэн Ли")
        movieGenres.add("Стив Дитко")
        movieGenres.add("Мартин Гудмен")
        movieGenres.add("Марк Миллар")
    }
}
