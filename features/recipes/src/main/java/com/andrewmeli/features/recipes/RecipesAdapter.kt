package com.andrewmeli.features.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrewmeli.features.recipes.databinding.LayoutRecipeItemBinding
import com.andrewmeli.libraries.model.Recipe
import com.andrewmeli.libraries.uicomponents.BaseListAdapter
import com.andrewmeli.libraries.uicomponents.extensions.onSingleClickListener
import com.squareup.picasso.Picasso


class RecipesAdapter : BaseListAdapter<Recipe, RecipesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesAdapter.ViewHolder {
        return ViewHolder(
            LayoutRecipeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(private val binding: LayoutRecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.apply {
                Picasso.get()
                    .load(recipe.image)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(imageView)

                textViewName.text = recipe.label
                textViewCuisineType.text = recipe.cuisineType?.joinToString { it.label ?: "" }

                container.onSingleClickListener {
                    onViewClickListeners.invoke(it.id, recipe)
                }
            }
        }
    }
}
