package edu.example.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
import edu.example.dam2024.features.superhero.domain.Superhero

class SuperheroActivity : AppCompatActivity() {

    private val superHeroFactory = SuperheroFactory()
    private val viewModel = superHeroFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_superheroe)
        val superheroes = viewModel.viewCreated()
        bindData(superheroes)
        //Log.d("@dev", superheroes.toString())
    }

    private fun bindData(superheroes: List<Superhero>){
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_powerstats_1).text = superheroes[0].powerStats
        findViewById<TextView>(R.id.superhero_name_1).text = superheroes[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val superhero1: Superhero? = viewModel.itemSelected(superheroes[0].id)
            superhero1?.let {
                Log.d("@dev", "Superheroe seleccionado: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superheroes[1].name
        findViewById<TextView>(R.id.superhero_powerstats_2).text = superheroes[1].powerStats

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superheroes[2].name
        findViewById<TextView>(R.id.superhero_powerstats_3).text = superheroes[2].powerStats
    }

}