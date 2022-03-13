package com.andrewmeli.libraries.repository.network

import com.andrewmeli.libraries.repository.network.responses.RecipeDTO
import com.andrewmeli.libraries.repository.network.responses.RecipesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface IEdamamAPI {

    //  The app_id parameter is the application ID created when generating the Edamam Application Key
    //  The app_key parameter is the Edamam Application Key generated to access the Search Recipes API
    //  The type parameter is the type of recipes to earch for - always 'public'
    //  The q parameter is the search criteria used to filter the response
    @GET("api/recipes/v2")
    suspend fun getRecipes(
        @Query("app_id") app_id: String,
        @Query("app_key") app_key: String,
        @Query("type") type: String,
        @Query("q") q: String
    ): Response<RecipesResponse>
}
