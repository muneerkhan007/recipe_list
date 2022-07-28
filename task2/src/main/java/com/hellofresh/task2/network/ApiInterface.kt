package com.hellofresh.task2.network

import com.hellofresh.task2.home.model.RecipeModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("recipes.json")
    fun fetchAllRecipes(): Call<List<RecipeModel>>
}