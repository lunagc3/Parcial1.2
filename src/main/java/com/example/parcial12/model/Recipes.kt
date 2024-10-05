package com.example.parcial12.model

import retrofit2.http.Url

data class Recipes (
    var id : Int,
    var title: String,
    var image: String,
    var imageType: String
)