package com.example.rick_and_morty.data.data

import com.example.rick_and_morty.data.api.CharactersApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {



    @Provides
    @Singleton
    fun provideCharactersApi(): CharactersApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersApi::class.java)
    }





}