package br.com.heiderlopes.pokemonwstemplate.view.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.heiderlopes.pokemonwstemplate.R
import br.com.heiderlopes.pokemonwstemplate.view.form.FormPokemonActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_pokemons.*
import kotlinx.android.synthetic.main.include_loading.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListPokemonsActivity : AppCompatActivity() {

    val listPokemonsViewModel: ListPokemonsViewModel by viewModel()
    val picasso: Picasso by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pokemons)

        listPokemonsViewModel.getPokemons()

        listPokemonsViewModel.isLoading.observe(this, Observer {
            if(it == true) {
                containerLoading.visibility = View.VISIBLE
            } else {
                containerLoading.visibility = View.GONE
            }
        })

        listPokemonsViewModel.messageError.observe(this, Observer {
            if(it != "") {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        listPokemonsViewModel.pokemons.observe(this, Observer {
            rvPokemons.adapter = ListPokemonsAdapter(it, picasso) {
                val intent = Intent(this, FormPokemonActivity::class.java)
                intent.putExtra("POKEMON", it)
                startActivity(intent)
                finish()
            }
            rvPokemons.layoutManager = GridLayoutManager(this, 3)
        })

    }
}