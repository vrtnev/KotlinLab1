package com.example.lab1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recyclerview_genre_row.view.*

class AuthorsAdapter(private val movieGenres : ArrayList<String>,
                     private val context: Context,
                     val onItemClick: ItemClick) : RecyclerView.Adapter<AuthorsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvGenreName.text = movieGenres[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_genre_row, parent,false),onItemClick)
    }

    override fun getItemCount(): Int {
        return movieGenres.size
    }

    class ViewHolder (view: View, val onItemClick: ItemClick) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvGenreName = view.btnGenre!!

        init {
           // val tvGenreName = view.btnGenre!!
            tvGenreName.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onItemClick.onItemClick(adapterPosition)
        }

    }

}