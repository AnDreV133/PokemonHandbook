package com.example.pokemonhandbook

import com.example.pokemonhandbook.api.PokemonApiHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import retrofit2.await

class ApiTest {
    @Test
    fun getPokemon(): Unit = runBlocking {
        val p = async {
            PokemonApiHandler.get(1).body()
        }.await()

        assertEquals(p?.name, "bulbasaur")
        assertEquals(
            p?.sprites?.frontDefault,
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        )
    }

//    @Test
//    fun getPokemonList(): Unit = runBlocking {
//        val p = async {
//            PokemonApiHandler.getByDiapason(1, 10).await()
//        }.await()
//
//        assertEquals(p?.get(3)?.name, "charmeleon")
//        assertEquals(p?.get(5)?.name, "squirtle")
//    }
}