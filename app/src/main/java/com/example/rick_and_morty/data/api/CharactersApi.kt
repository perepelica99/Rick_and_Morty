package com.example.rick_and_morty.data.api

import com.example.rick_and_morty.data.models.Characters
import com.example.rick_and_morty.data.models.PagedResponse
import retrofit2.Response
import retrofit2.http.*


abstract class CharactersApi {

    @GET("character/")
    abstract suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?
    ): PagedResponse<Characters>


    @GET("character/{ids}")
   abstract suspend fun getCharactersByIds(
        @Path("ids") ids: String
    ): Response<List<Characters>>
}