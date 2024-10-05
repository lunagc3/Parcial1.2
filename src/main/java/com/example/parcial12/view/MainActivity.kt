package com.example.parcial12.view

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial12.databinding.ActivityMainBinding
import com.example.parcial12.model.APIService
import com.example.parcial12.model.Recipes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecipesAdapter
    private var recipesData = mutableListOf<Recipes>()
    private var apiKey = "c4cd41151cda4776af071a231132d161"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/recipes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getRecipes(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getRecipes("/complexSearch?c4cd41151cda4776af071a231132d161")
            val recipes = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    //recycler
                    var recipesArray = recipes?.recipes ?: emptyList()
                    recipesData.clear()
                    for(recipe in recipesArray){
                        var recipeImages = mutableListOf<String>()
                        recipeImages.add(recipe.image)
                        recipesData.addAll(recipesData)
                    }
                    adapter.notifyDataSetChanged()
                }else{
                    //error
                    showError()
                }
            }
        }
    }
    private fun showError(){
        Toast.makeText(this, "Ocurrio un error", Toast.LENGTH_SHORT).show()
    }

    private fun getRecipesById(id:Path, url:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getRecipesById(id, "/summary?c4cd41151cda4776af071a231132d161")
            val recipe = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    //mostrar detalles

                }else{
                    //error
                    showError()
                }
            }
        }
    }

    private fun initRecyclerView(){

        adapter = RecipesAdapter(recipesData)
        binding.rvRecipes.layoutManager = LinearLayoutManager(this)
        binding.rvRecipes.adapter = adapter
        getRecipes()
    }
}
