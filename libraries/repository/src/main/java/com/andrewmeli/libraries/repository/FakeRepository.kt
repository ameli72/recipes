package com.andrewmeli.libraries.repository

import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.others.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FakeRepository : IRepository {
    private val recipes = mutableListOf<Recipe>(
        Recipe("", "Chicken 1", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Beef 1", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Beef 2", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Corn 1", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Chicken 2", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Roast 1", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Roast 2", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Chicken 3", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Chicken 4", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
        Recipe("", "Roast 3", "", "", "", "", 0f, listOf(), 0f, 0f, 0f, "", 0f, listOf()),
    )

    override suspend fun getRecipes(searchPhase: String): Flow<Resource<List<Recipe>>> = flow {
        emit(Resource.success(recipes.filter { it.label?.contains(searchPhase, true) == true }))
    }
}