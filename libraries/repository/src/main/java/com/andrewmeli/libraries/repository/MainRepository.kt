package com.andrewmeli.libraries.repository

import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.mappers.NetworkMapper
import com.andrewmeli.libraries.repository.network.IEdamamAPI
import com.andrewmeli.libraries.repository.others.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MainRepository constructor(
    private val retrofit: IEdamamAPI,
    private val mapper: NetworkMapper
) : IRepository {

    override suspend fun getRecipes(searchPhase: String): Flow<Resource<List<Recipe>>> = flow {
        emit(Resource.loading(null))

        try {
            val recipes =
                retrofit.getRecipes(
                    EDAMAM_APP_ID,
                    EDAMAM_APP_KEY,
                    RECIPE_SEARCH_TYPE,
                    searchPhase
                ).body()?.hits?.map { hit -> hit.recipe }
            emit(Resource.success(mapper.mapToModelList(recipes ?: listOf())))
        } catch (e: Exception) {
            emit(Resource.error(e, null))
        }
    }


    companion object {
        private const val EDAMAM_APP_ID = "941ab258"
        private const val EDAMAM_APP_KEY = "142e696cec7a1f3193256369ac89a7f3"
        private const val RECIPE_SEARCH_TYPE = "public"
    }
}