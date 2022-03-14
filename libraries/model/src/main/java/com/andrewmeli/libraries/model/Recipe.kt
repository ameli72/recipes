package com.andrewmeli.libraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Recipe(
    var uri: String?,
    var label: String?,
    var image: String?,

//images (Inline Model 1, optional),

    var source: String?,
    var url: String?,
    var shareAs: String?,
    var yield: Float?,

//dietLabels (Array[string], optional),
//healthLabels (Array[string], optional),
//cautions (Array[string], optional),
//ingredientLines (Array[string], optional),
//ingredients (Array[Ingredient], optional),

    var calories: Float?,
    var glycemicIndex: Float?,
    var totalCO2Emissions: Float?,
    var co2EmissionsClass: String?,
    var totalWeight: Float?,

//cuisineType (Array[string], optional),
//mealType (Array[string], optional),
//dishType (Array[string], optional),
//totalNutrients (NutrientsInfo, optional),
//totalDaily (NutrientsInfo, optional),
//digest (Digest, optional)
) : Parcelable, IComparer {
    override fun areItemsTheSame(compareTo: IComparer): Boolean =
        uri == (compareTo as Recipe).uri

    override fun areContentsTheSame(compareTo: IComparer): Boolean =
        this == (compareTo as Recipe)
}
