package com.example.lab1

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity(), ItemClick {

    override fun onItemClick(pos: Int) {
        val movieName = films[pos].name
        val countryName = films[pos].country
        val rating = films[pos].rating
        val image = films[pos].image
        val genre = films[pos].genre

        val intent = Intent(this, MovieActivity::class.java)
        intent.putExtra("name", movieName)
        intent.putExtra("country", countryName)
        intent.putExtra("rating", rating)
        intent.putExtra("image", image)
        intent.putExtra("genre", genre)
        startActivity(intent)
    }

    var films: ArrayList<Film> = ArrayList()
    var filterFilm: ArrayList<Film> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        addMovies()
        val genre = intent.getStringExtra("genre")
        if (genre == null) {
            filterFilm = films
        } else {
            filterFilm = films.filter { s -> s.genre == genre } as ArrayList
        }
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesRecyclerView.adapter = MoviesAdapter(filterFilm, this,this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun addMovies() {
        films.add(Film("Фильм 1", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 2", "Австралия", "5", "Комедия", R.drawable.img2))
        films.add(Film("Фильм 3", "Иран", "5", "Трагикомедия", R.drawable.img3))
        films.add(Film("Фильм 4", "США", "5", "Комедия", R.drawable.img4))
        films.add(Film("Фильм 5", "Канада", "5", "Драма", R.drawable.img5))
        films.add(Film("Фильм 6", "Россия", "5", "Комедия", R.drawable.img6))
        films.add(Film("Фильм 7", "Россия", "4", "Боевик", R.drawable.img7))
        films.add(Film("Фильм 8", "Россия", "5", "Боевик", R.drawable.img8))
        films.add(Film("Фильм 9", "Россия", "5", "Драма", R.drawable.img9))
        films.add(Film("Фильм 10", "Россия", "5", "Комедия", R.drawable.img10))
        films.add(Film("Фильм 11", "Россия", "5", "Драма", R.drawable.img11))
        films.add(Film("Фильм 12", "Россия", "5", "Комедия", R.drawable.img12))
        films.add(Film("Фильм 13", "Россия", "5", "Комедия", R.drawable.img13))
        films.add(Film("Фильм 14", "Россия", "5", "Трагикомедия", R.drawable.img14))
        films.add(Film("Фильм 15", "Россия", "5", "Комедия", R.drawable.img15))
        films.add(Film("Фильм 16", "Россия", "5", "Комедия", R.drawable.img16))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.about -> {
                about()
                return true
            }
            R.id.genre -> {
                genres()
                return true
            }
            R.id.logout -> {
                logout()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    fun about() {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
    }

    fun genres() {
        val intent = Intent(this, GenresActivity::class.java)
        startActivity(intent)
    }

    fun logout() {
        finish()
    }


}
