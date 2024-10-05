package com.example.parcial12.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcial12.model.Recipes


class RecipesViewModel : ViewModel(){
    private val _recipes = MutableLiveData<List<Recipes>>()
    val recipes: LiveData<List<Recipes>> get() = _recipes

}