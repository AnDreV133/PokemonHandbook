package com.example.pokemonhandbook.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pokemons(
    @SerializedName("results") val results: List<Pokemon>
) : Serializable

data class Pokemon(
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("stats") val stats: List<Stat>,
    @SerializedName("sprites") val sprites: Sprites
) : Serializable

data class Sprites(
    @SerializedName("front_default") val frontDefault: String
) : Serializable

data class Stat(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("effort") val effort: Int,
    @SerializedName("stat") val stat: StatDetail,
) : Serializable

data class StatDetail(
    @SerializedName("name") val name: String,
) : Serializable