package com.example.lab1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

interface ItemClick {
    fun onItemClick(pos: Int)
}

data class Film (val name: String,
                 val country: String,
                 val rating: String,
                 val genre: String,
                 val image: Int)

class MoviesAdapter(private val films: ArrayList<Film>,
                    private val context: Context,
                    val onItemClick: ComixListActivity
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvMovieName.text = films[position].name
        //holder.tvCountryName.text = films[position].country
        holder.tvRating.text = films[position].rating
        holder.imImage.setImageResource(films[position].image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_row, parent, false), onItemClick)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    class ViewHolder (view: View, val onItemClick: ItemClick) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvMovieName = view.movieName!!
        //val tvCountryName = view.countryName!!
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