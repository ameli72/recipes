package com.andrewmeli.features.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrewmeli.features.recipes.databinding.LayoutIngredientsItemBinding
import com.andrewmeli.libraries.model.Ingredient
import com.andrewmeli.libraries.uicomponents.BaseListAdapter


class IngredientsAdapter : BaseListAdapter<Ingredient, IngredientsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.ViewHolder {
        return ViewHolder(
            LayoutIngredientsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(private val binding: LayoutIngredientsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: Ingredient) {
            binding.apply {
                textView.text = ingredient.label
            }
        }
    }
}
