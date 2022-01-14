package com.example.cityexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CityAdapter : RecyclerView.Adapter<CityAdapter.Holder>() {

    private val cities = listOf(
        "Seoul" to "SEO",
        "Tokyo" to "TOK",
        "Mountain View" to "MTV",
        "Singapore" to "SIN",
        "New York" to "NYC")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(parent)

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val(city, code) = cities[position]

    }

    override fun getItemCount() = cities.size

    inner class Holder(parent: ViewGroup)
        : RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.activity_main, parent, false))
}