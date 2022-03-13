package com.andrewmeli.libraries.repository.di

import com.andrewmeli.libraries.repository.IRepository
import com.andrewmeli.libraries.repository.MainRepository
import com.andrewmeli.libraries.repository.mappers.NetworkMapper
import com.andrewmeli.libraries.repository.network.IEdamamAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        retrofit: IEdamamAPI,
        mapper: NetworkMapper
    ) = MainRepository(retrofit, mapper) as IRepository
}