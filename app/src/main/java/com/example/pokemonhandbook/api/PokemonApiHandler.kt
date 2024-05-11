package com.example.pokemonhandbook.api

import android.util.Log
import com.example.pokemonhandbook.api.model.Pokemon
import com.example.pokemonhandbook.api.model.Sprites
import retrofit2.Call
import retrofit2.Callback
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

//    private fun <T> body(call: Call<T>): T? {
//        var res: T? = null
//        call.enqueue( object : Callback<T> {
//            override fun onResponse(call: Call<T>, response: Response<T>) {
//                res = if (response.isSuccessful) response.body() else null
//
//                Log.d("PokemonApiHandler", "returned object from execute to API:\n$res")
//            }
//
//            override fun onFailure(call: Call<T>, t: Throwable) {
//                Log.e("PokemonApiHandler", "failed to execute to API:\n$t")
//            }
//        })
//
//        return res
//    }
//
//    suspend fun get(id: Int): Pokemon? {
//        return body(api.get(id))
//    }
//
//    suspend fun getByDiapason(offset: Int, limit: Int): List<Pokemon>? {
//        return body(api.getByDiapason(offset, limit))?.results
//    }

//    suspend fun getSprites(id: Int): Sprites? {
//        return body(api.get(id))?.sprites
//    }

    suspend fun get(id: Int): Response<Pokemon> {
        return api.get(id)
    }
}