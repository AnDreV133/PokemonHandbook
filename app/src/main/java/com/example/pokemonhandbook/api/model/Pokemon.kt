package com.example.pokemonhandbook.api.model

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class Pokemon(
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("stats") val stats: List<Stats>,
    @SerializedName("sprites") val sprites: Sprites
)

class Sprites(
    @SerializedName("front_default") val frontDefault: String
)

class Stats(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("effort") val effort: Int,
    @SerializedName("stat") val stat: Stat,
)

class Stat(
    @SerializedName("name") val name: String,
)

interface PokemonApi {
    @GET("pokemon/{id}/")
    suspend fun get(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon")
    suspend fun getByDiapason(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Response<List<Pokemon>>
//    @GET("pokemon/{id}/")
//    suspend fun getImage(id: Int): Response<Sprites> {
//        return get(id).enqueue()
//    }

}