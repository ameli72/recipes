package com.andrewmeli.features.recipes.di

import androidx.lifecycle.LiveData
import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.others.Event
import com.andrewmeli.libraries.repository.others.Resource


interface IRecipesViewModel {
    val recipes: LiveData<Event<Resource<List<Recipe>>>>

    fun getRecipes(searchPhase: String)
    fun clearRecipes()
}
