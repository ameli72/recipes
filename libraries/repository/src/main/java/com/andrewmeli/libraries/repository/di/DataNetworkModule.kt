package com.andrewmeli.libraries.repository.di

import com.andrewmeli.libraries.repository.network.IEdamamAPI
import com.andrewmeli.libraries.repository.others.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataNetworkModule {

    @Singleton
    @Provides
    fun providesGSonBuilder(): Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))

    @Singleton
    @Provides
    fun provideEdamamService(retrofit: Retrofit.Builder): IEdamamAPI = retrofit
        .build()
        .create(IEdamamAPI::class.java)
}