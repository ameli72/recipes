package com.andrewmeli.libraries.repository.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class RecipeDTO(
    @SerializedName("uri")
    @Expose
    var uri: String?,

    @SerializedName("label")
    @Expose
    var label: String?,

    @SerializedName("image")
    @Expose
    var image: String?,

//images (Inline Model 1, optional),

    @SerializedName("source")
    @Expose
    var source: String?,

    @SerializedName("url")
    @Expose
    var url: String?,

    @SerializedName("shareAs")
    @Expose
    var shareAs: String?,

    @SerializedName("yield")
    @Expose
    var yield: Float?,

//dietLabels (Array[string], optional),
//healthLabels (Array[string], optional),
//cautions (Array[string], optional),

    @SerializedName("ingredientLines")
    @Expose
    var ingredientLines: List<String>?,

//ingredients (Array[Ingredient], optional),

    @SerializedName("calories")
    @Expose
    var calories: Float?,

    @SerializedName("glycemicIndex")
    @Expose
    var glycemicIndex: Float?,

    @SerializedName("totalCO2Emissions")
    @Expose
    var totalCO2Emissions: Float?,

    @SerializedName("co2EmissionsClass")
    @Expose
    var co2EmissionsClass: String?,

    @SerializedName("totalWeight")
    @Expose
    var totalWeight: Float?,

    @SerializedName("cuisineType")
    @Expose
    var cuisineType: List<String>?,

//mealType (Array[string], optional),
//dishType (Array[string], optional),
//totalNutrients (NutrientsInfo, optional),
//totalDaily (NutrientsInfo, optional),
//digest (Digest, optional)
)
