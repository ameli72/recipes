package com.andrewmeli.features.recipes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.andrewmeli.features.recipes.databinding.FragmentRecipiesBinding
import com.andrewmeli.features.recipes.di.IRecipesViewModel
import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.repository.others.Event
import com.andrewmeli.libraries.repository.others.Resource
import com.andrewmeli.libraries.repository.others.Status
import com.andrewmeli.libraries.uicomponents.BaseFragment
import com.andrewmeli.libraries.uicomponents.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class RecipesFragment @Inject constructor() : BaseFragment() {
    private val binding by viewBinding(FragmentRecipiesBinding::bind)
    private val navController by lazy { findNavController() }

    private var adapter = RecipesAdapter()

    @Inject
    lateinit var viewModel: IRecipesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_recipies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initViews()
    }

    private fun initViewModel() {
        viewModel.apply {
            recipes.observe(viewLifecycleOwner) { recipesEvent(it) }
        }
    }


    private fun initViews() = binding.apply {
        searchView.apply {
            isSubmitButtonEnabled = true

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    viewModel.getRecipes(searchView.query.toString())
                    return false
                }

                override fun onQueryTextChange(searchPhase: String?): Boolean {
                    searchPhase?.let { if (it.isEmpty()) viewModel.clearRecipes() }
                    return false
                }
            })
        }

        adapter.setOnViewClickListener<Recipe> { recipe, imageView ->
            Log.e(TAG, recipe.label ?: "!!NO LABEL!!")

            val extras = FragmentNavigatorExtras(imageView to recipe.uri.toString())
            navController.navigate(
                RecipesFragmentDirections.actionRecipesFragmentToRecipeFragment(recipe), extras
            )
        }
        recyclerView.adapter = adapter
    }

    private fun recipesEvent(event: Event<Resource<List<Recipe>>>?) =
        event?.getContentIfNotHandled()?.let { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    dismissDialog()

                    resource.data?.let {
                        //Reset position to All
                        adapter.setData(it)
                    } ?: run {
                        Log.e(TAG, "Recipes Event: missing result")

                        //TODO: Show error in Alert
                    }
                }

                //TODO: showError?
                Status.ERROR -> {
                    dismissDialog()
                    Log.e(TAG, "Recipes Event: Error - ${resource.exception?.message}")

                    //TODO: Show error in Alert
                }

                Status.LOADING ->
                    showDialog()
            }
        }
}