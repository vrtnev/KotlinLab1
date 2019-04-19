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
        val movieName = movieNames[pos]
        val countryName = countryNames[pos]
        val rating = ratings[pos]
        val image = images[pos]
        val genre = genres[pos]

        var films: ArrayList<Film> = ArrayList()

        films.add(Film("Фильм 1", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 2", "Австралия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 3", "Иран", "5", "Трагикомедия", R.drawable.img1))
        films.add(Film("Фильм 4", "США", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 5", "Канада", "5", "Драма", R.drawable.img1))
        films.add(Film("Фильм 6", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 7", "Россия", "4", "Боевик", R.drawable.img1))
        films.add(Film("Фильм 8", "Россия", "5", "Боевик", R.drawable.img1))
        films.add(Film("Фильм 9", "Россия", "5", "Драма", R.drawable.img1))
        films.add(Film("Фильм 10", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 11", "Россия", "5", "Драма", R.drawable.img1))
        films.add(Film("Фильм 12", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 13", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 14", "Россия", "5", "Трагикомедия", R.drawable.img1))
        films.add(Film("Фильм 15", "Россия", "5", "Комедия", R.drawable.img1))
        films.add(Film("Фильм 16", "Россия", "5", "Комедия", R.drawable.img1))

        var filterFilm = films.filter { s -> s.genre == "Комедия" }

        val intent = Intent(this, MovieActivity::class.java)
        intent.putExtra("name", movieName)
        intent.putExtra("country", countryName)
        intent.putExtra("rating", rating)
        intent.putExtra("image", image)
        intent.putExtra("genre", genre)
        startActivity(intent)
    }

    val movieNames: ArrayList<String> = ArrayList()
    val countryNames: ArrayList<String> = ArrayList()
    val ratings: ArrayList<String> = ArrayList()
    val images: ArrayList<Int> = ArrayList()
    val genres: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        addMovies()
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesRecyclerView.adapter = MoviesAdapter(movieNames, countryNames, ratings, images, genres, this,this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun addMovies() {
        movieNames.add("Фильм 1")
        movieNames.add("Фильм 2")
        movieNames.add("Фильм 3")
        movieNames.add("Фильм 4")
        movieNames.add("Фильм 5")
        movieNames.add("Фильм 6")
        movieNames.add("Фильм 7")
        movieNames.add("Фильм 8")
        movieNames.add("Фильм 9")
        movieNames.add("Фильм 10")
        movieNames.add("Фильм 11")
        movieNames.add("Фильм 12")
        movieNames.add("Фильм 13")
        movieNames.add("Фильм 14")
        movieNames.add("Фильм 15")
        movieNames.add("Фильм 16")
        countryNames.add("Россия")
        countryNames.add("Австралия")
        countryNames.add("Иран")
        countryNames.add("США")
        countryNames.add("Канада")
        countryNames.add("Украина")
        countryNames.add("Беларусь")
        countryNames.add("Эстония")
        countryNames.add("Польша")
        countryNames.add("Финляндия")
        countryNames.add("Швеция")
        countryNames.add("Латвия")
        countryNames.add("Литва")
        countryNames.add("Германия")
        countryNames.add("Испания")
        countryNames.add("Нидерланды")
        ratings.add("5")
        ratings.add("3.2")
        ratings.add("4.7")
        ratings.add("2.1")
        ratings.add("0")
        ratings.add("1.6")
        ratings.add("4.9")
        ratings.add("5")
        ratings.add("5")
        ratings.add("2.2")
        ratings.add("3.5")
        ratings.add("4")
        ratings.add("3")
        ratings.add("2")
        ratings.add("1")
        ratings.add("5")
        images.add(R.drawable.img1)
        images.add(R.drawable.img2)
        images.add(R.drawable.img3)
        images.add(R.drawable.img4)
        images.add(R.drawable.img5)
        images.add(R.drawable.img6)
        images.add(R.drawable.img7)
        images.add(R.drawable.img8)
        images.add(R.drawable.img9)
        images.add(R.drawable.img10)
        images.add(R.drawable.img11)
        images.add(R.drawable.img12)
        images.add(R.drawable.img13)
        images.add(R.drawable.img14)
        images.add(R.drawable.img15)
        images.add(R.drawable.img16)
        genres.add("Комедия")
        genres.add("Трагикомедия")
        genres.add("Комедия")
        genres.add("Драма")
        genres.add("Комедия")
        genres.add("Комедия")
        genres.add("Боевик")
        genres.add("Комедия")
        genres.add("Трагикомедия")
        genres.add("Комедия")
        genres.add("Комедия")
        genres.add("Боевик")
        genres.add("Комедия")
        genres.add("Комедия")
        genres.add("Драма")
        genres.add("Драма")
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
