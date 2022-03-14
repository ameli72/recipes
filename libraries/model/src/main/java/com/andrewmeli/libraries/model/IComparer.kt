package com.andrewmeli.libraries.model


interface IComparer {
    fun areItemsTheSame(compareTo: IComparer): Boolean
    fun areContentsTheSame(compareTo: IComparer): Boolean
}