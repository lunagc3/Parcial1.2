package com.example.parcial12.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.parcial12.databinding.ItemRecipesBinding
import com.example.parcial12.model.Recipes
import com.squareup.picasso.Picasso

class RecipesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRecipesBinding.bind(view)
    fun bind(recipe:Recipes){
        binding.tvTitle.text = recipe.title
        Picasso.get().load(recipe.image).into(binding.ivRecipes)
    }
}