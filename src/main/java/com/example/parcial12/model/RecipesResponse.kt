package com.example.parcial12.model

import com.google.gson.annotations.SerializedName

data class RecipesResponse (
    @SerializedName("results") var recipes: List<Recipes>,
    var offset:Int,
    var number: Int,
    var totalResults:Int
)