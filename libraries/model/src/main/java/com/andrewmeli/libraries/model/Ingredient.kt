package com.andrewmeli.libraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Ingredient(
    var label: String?,
) : Parcelable, IComparer {
    override fun areItemsTheSame(compareTo: IComparer): Boolean =
        label == (compareTo as Ingredient).label

    override fun areContentsTheSame(compareTo: IComparer): Boolean =
        this == (compareTo as Ingredient)
}
