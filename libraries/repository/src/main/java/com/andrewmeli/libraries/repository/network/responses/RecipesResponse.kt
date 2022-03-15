package com.andrewmeli.libraries.repository.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class RecipesResponse(
    @SerializedName("from")
    @Expose
    var from: Int?,

    @SerializedName("to")
    @Expose
    var to: Int?,

    @SerializedName("count")
    @Expose
    var count: Int?,


//    _links (Links, optional),


    @SerializedName("hits")
    @Expose
    var hits: List<Hit>?
)

data class Hit(
    @SerializedName("recipe")
    @Expose
    var recipe: RecipeDTO
)
