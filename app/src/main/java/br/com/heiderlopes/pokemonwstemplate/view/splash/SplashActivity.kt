package br.com.heiderlopes.pokemonwstemplate.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.heiderlopes.pokemonwstemplate.R
import br.com.heiderlopes.pokemonwstemplate.view.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


    }
}
