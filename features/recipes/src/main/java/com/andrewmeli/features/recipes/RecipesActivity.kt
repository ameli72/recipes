package com.andrewmeli.features.recipes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.andrewmeli.features.recipes.di.IRecipesViewModel
import com.andrewmeli.libraries.repository.others.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RecipesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: IRecipesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel.apply {
            githubProjects.observe(this@RecipesActivity) {
                it.getContentIfNotHandled()?.let {
                    Log.e("RECIPES", "${it.status} - ${it.data?.size ?: 0}")

                    if (it.status == Status.SUCCESS)
                        it.data?.forEach { Log.e("RECIPE", it.label ?: "!!NO LABEL!!") }
                }
            }
        }
    }
}