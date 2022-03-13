package com.andrewmeli.libraries.repository

import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.others.Resource
import kotlinx.coroutines.flow.Flow


interface IRepository {
    suspend fun getRecipes(searchPhase: String): Flow<Resource<List<Recipe>>>
}