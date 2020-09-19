package br.com.heiderlopes.pokemonwstemplate.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("content")val conteudo: List<Pokemon>
)