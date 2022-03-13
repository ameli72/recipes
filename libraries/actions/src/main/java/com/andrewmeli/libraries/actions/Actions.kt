package com.andrewmeli.libraries.actions

import android.content.Context
import android.content.Intent


object Actions {
    fun openRecipesIntent(context: Context) =
        internalIntent(context, "com.andrewmeli.features.recipes.open")


    private fun internalIntent(context: Context, action: String) =
        Intent(action).setPackage(context.packageName)
}