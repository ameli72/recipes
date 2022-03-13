package com.andrewmeli.features.recipes.di

import com.andrewmeli.features.recipes.RecipesViewModel
import com.andrewmeli.libraries.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideGithubViewModel(
        repository: IRepository
    ): IRecipesViewModel = RecipesViewModel(repository)
}