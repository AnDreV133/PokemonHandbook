package com.example.pokemonhandbook.api

import com.example.pokemonhandbook.api.model.Pokemon
import com.example.pokemonhandbook.api.model.PokemonApi
import com.example.pokemonhandbook.api.model.Sprites
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonApiHandler {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokemonApi::class.java)

    private fun <T> body(resp: Response<T>) =
        if (resp.isSuccessful && resp.body() != null) resp.body()
        else null

    suspend fun get(id: Int): Pokemon? {
        return body(api.get(id))
    }

    suspend fun getByDiapason(offset: Int, limit: Int): List<Pokemon>? {
        return body(api.getByDiapason(offset, limit))
    }

    suspend fun getSprites(id: Int): Sprites? {
        return body(api.get(id))?.sprites
    }
}