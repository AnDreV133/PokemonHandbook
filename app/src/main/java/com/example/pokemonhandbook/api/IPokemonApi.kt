package com.example.pokemonhandbook.api

import com.example.pokemonhandbook.api.model.Pokemon
import com.example.pokemonhandbook.api.model.Pokemons
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPokemonApi {
    @GET("pokemon/{id}/")
    suspend fun get(
        @Path("id") id: Int
    ): Response<Pokemon>

    @GET("pokemon")
    suspend fun getByDiapason(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<Pokemons>
}