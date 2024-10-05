package com.example.parcial12.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    @GET("{id}/summary")
    fun getRecipesById(
        @Path("id") id: Path,
        @Url summary:String,
        //@Query("apiKey") apiKey:String
    ):Response<RecipesIDResponse>
    @GET("complexSearch")
    fun getRecipes(
        @Url url:String
        //@Query("apiKey") apiKey:String
    ): Response<RecipesResponse>
}