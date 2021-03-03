package br.com.heiderlopes.pokemonwstemplate.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.heiderlopes.pokemonwstemplate.R
import br.com.heiderlopes.pokemonwstemplate.view.main.MainActivity
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        splashViewModel.checkHealth()

        splashViewModel.responseData.observe(this, Observer {
            if(it.isNullOrEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Não foi possivel carregar os dados", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
