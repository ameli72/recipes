package com.andrewmeli.libraries.repository.mappers

import com.andrewmeli.libraries.model.CuisineType
import com.andrewmeli.libraries.model.Ingredient
import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.network.responses.RecipeDTO
import javax.inject.Inject


class NetworkMapper @Inject
constructor() : IModelMapper<RecipeDTO, Recipe> {

    override fun mapToModel(dto: RecipeDTO): Recipe {
        return Recipe(
            uri = dto.uri,
            label = dto.label,
            image = dto.image,

//            images (Inline Model 1, optional),

            source = dto.source,
            url = dto.url,
            shareAs = dto.shareAs,
            yield = dto.yield,

//            dietLabels (Array[string], optional),
//            healthLabels (Array[string], optional),
//            cautions (Array[string], optional),

            ingredientLines = dto.ingredientLines?.map { Ingredient(it) },

//            ingredients (Array[string], optional),

            calories = dto.calories,
            glycemicIndex = dto.glycemicIndex,
            totalCO2Emissions = dto.totalCO2Emissions,
            co2EmissionsClass = dto.co2EmissionsClass,
            totalWeight = dto.totalWeight,
            cuisineType = dto.cuisineType?.map { CuisineType(it) },

//            mealType (Array[string], optional),
//            dishType (Array[string], optional),
//            totalNutrients (NutrientsInfo, optional),
//            totalDaily (NutrientsInfo, optional),
//            digest (Digest, optional)
        )
    }

    override fun mapFromModel(model: Recipe): RecipeDTO {
        return RecipeDTO(
            uri = model.uri,
            label = model.label,
            image = model.image,

//            images (Inline Model 1, optional),

            source = model.source,
            url = model.url,
            shareAs = model.shareAs,
            yield = model.yield,

//            dietLabels (Array[string], optional),
//            healthLabels (Array[string], optional),
//            cautions (Array[string], optional),

            ingredientLines = model.ingredientLines?.map { it.label ?: "" },

//            ingredients (Array[string], optional),

            calories = model.calories,
            glycemicIndex = model.glycemicIndex,
            totalCO2Emissions = model.totalCO2Emissions,
            co2EmissionsClass = model.co2EmissionsClass,
            totalWeight = model.totalWeight,
            cuisineType = model.cuisineType?.map { it.label ?: "" },

//            mealType (Array[string], optional),
//            dishType (Array[string], optional),
//            totalNutrients (NutrientsInfo, optional),
//            totalDaily (NutrientsInfo, optional),
//            digest (Digest, optional)
        )
    }

    override fun mapToModelList(dtos: List<RecipeDTO>): List<Recipe> =
        dtos.map { mapToModel(it) }
}