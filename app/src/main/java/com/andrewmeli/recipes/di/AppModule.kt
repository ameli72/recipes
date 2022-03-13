package com.andrewmeli.recipes.di

import com.andrewmeli.recipes.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideSplashViewModel(): IMainViewModel = MainViewModel()
}