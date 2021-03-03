package br.com.heiderlopes.pokemonwstemplate.api

import br.com.heiderlopes.pokemonwstemplate.model.HealthResponse
import br.com.heiderlopes.pokemonwstemplate.model.Pokemon
import br.com.heiderlopes.pokemonwstemplate.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.*

interface PokemonService {

    @GET("/api/pokemon/health")
    fun checkHealth() : Call<HealthResponse>

    @GET("/api/pokemon")
    fun getPokemons(
        @Query("size") size: Int,
        @Query("sort") sort: String
    ): Call<PokemonResponse>

    @PUT("/api/pokemon")
    fun updatePokemon(
        @Body pokemon: Pokemon
    ) : Call<Pokemon>

    @GET("/api/pokemon/{number}")
    fun getPokemon(
        @Path("number") number: String
    ) : Call<Pokemon>
}