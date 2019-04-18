package com.example.lab1

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

interface ItemClick {
    fun onItemClick(pos: Int)
}

class MoviesAdapter(private val movieNames : ArrayList<String>,
                    private val movieCountries: ArrayList<String>,
                    private val movieRatings: ArrayList<String>,
                    private val movieImages: ArrayList<Int>,
                    private val movieGenres: ArrayList<String>,
                    private val context: Context,
                    val onItemClick: ItemClick) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMovieName.text = movieNames[position]
        holder.tvCountryName.text = movieCountries[position]
        holder.tvRating.text = movieRatings[position]
        holder.imImage.setImageResource(movieImages[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_row, parent, false), onItemClick)
    }

    override fun getItemCount(): Int {
        return movieNames.size
    }

    class ViewHolder (view: View, val onItemClick: ItemClick) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvMovieName = view.movieName!!
        val tvCountryName = view.countryName!!
        val tvRating = view.rating!!
        val imImage = view.imageView!!

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemClick.onItemClick(adapterPosition)
        }
    }
}