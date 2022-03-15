package com.andrewmeli.features.recipes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.transition.TransitionInflater
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
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RecipeFragment @Inject constructor() : BaseFragment() {
    private val binding by viewBinding(FragmentRecipeBinding::bind)
    private val navController by lazy { findNavController() }

    private var adapter = IngredientsAdapter()


    val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_recipe, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(args.recipe)
    }


    private fun initViews(recipe: Recipe) = binding.apply {

        textViewTitle.text = recipe.label
        imageView.apply {
            transitionName = recipe.uri.toString()
            Picasso.get()
                .load(recipe.image)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(this)
        }

        adapter.setData(recipe.ingredientLines)
        recyclerView.adapter = adapter

        textViewUrl.apply {
            text = recipe.url
            setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipe.url))
                startActivity(browserIntent)
            }
        }

        button.onSingleClickListener { navController.popBackStack() }
    }
}