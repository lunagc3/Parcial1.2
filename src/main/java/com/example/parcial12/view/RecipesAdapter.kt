package com.example.parcial12.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial12.R
import com.example.parcial12.model.Recipes
import retrofit2.http.Url

class RecipesAdapter(private val recipes: List<Recipes>) : RecyclerView.Adapter<RecipesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipesViewHolder(layoutInflater.inflate(R.layout.item_recipes, parent, false))
    }

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        var item = recipes[position]
        holder.bind(item)
    }
}