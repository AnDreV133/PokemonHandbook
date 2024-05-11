package com.example.pokemonhandbook.api

import com.example.pokemonhandbook.api.model.Pokemon
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonApiHandler {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IPokemonApi::class.java)

    suspend fun get(id: Int): Response<Pokemon> {
        return api.get(id)
    }
}