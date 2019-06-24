package com.example.lab1

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_movie.*

class ComixActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        movieImage.setImageResource(intent.getIntExtra("image", 0))
        movieName.setText(intent.getStringExtra("name"))
        movieCountry.setText(intent.getStringExtra("country"))
        movieRating.setText(intent.getStringExtra("rating"))
        movieGenre.setText(intent.getStringExtra("genre"))
    }

}
