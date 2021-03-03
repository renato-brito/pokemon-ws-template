package br.com.heiderlopes.pokemonwstemplate.repository

import br.com.heiderlopes.pokemonwstemplate.api.PokemonService
import br.com.heiderlopes.pokemonwstemplate.model.HealthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl(val pokemonService: PokemonService) : PokemonRepository {

    override fun checkHealth(onComplete: () -> Unit, onError: (Throwable?) -> Unit) {
        pokemonService
            .checkHealth()
            .enqueue(object : Callback<HealthResponse> {
                override fun onResponse(
                    call: Call<HealthResponse>, response: Response<HealthResponse>) {
                    if (response.isSuccessful) {
                        onComplete()
                    } else {
                        onError(Throwable("Erro check health"))
                    }
                }

                override fun onFailure(call: Call<HealthResponse>, t: Throwable) {
                    onError(t)
                }
            })
    }
}