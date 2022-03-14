package com.andrewmeli.libraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CuisineType(
    var label: String?,
) : Parcelable, IComparer {
    override fun areItemsTheSame(compareTo: IComparer): Boolean =
        label == (compareTo as CuisineType).label

    override fun areContentsTheSame(compareTo: IComparer): Boolean =
        this == (compareTo as CuisineType)
}
