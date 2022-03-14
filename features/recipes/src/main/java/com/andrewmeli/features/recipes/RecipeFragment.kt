package com.andrewmeli.features.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.andrewmeli.features.recipes.databinding.FragmentRecipeBinding
import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.uicomponents.BaseFragment
import com.andrewmeli.libraries.uicomponents.binding.viewBinding
import com.andrewmeli.libraries.uicomponents.extensions.onSingleClickListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RecipeFragment @Inject constructor() : BaseFragment() {
    private val binding by viewBinding(FragmentRecipeBinding::bind)
    private val navController by lazy { findNavController() }

    val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_recipe, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(args.recipe)
    }


    private fun initViews(recipe: Recipe) = binding.apply {

        textView.text = recipe.label
        button.onSingleClickListener {
            navController.popBackStack()
        }
    }
}