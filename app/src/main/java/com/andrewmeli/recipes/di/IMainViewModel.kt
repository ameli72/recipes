package com.andrewmeli.recipes.di

import androidx.lifecycle.LiveData


interface IMainViewModel {
    val timerCompleted: LiveData<Boolean>
}