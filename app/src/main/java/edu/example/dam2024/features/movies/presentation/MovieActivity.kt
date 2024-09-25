package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
import edu.example.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val moviewFactory: MovieFactory = MovieFactory()
    private val viewModel = moviewFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        bindData(movies)
        //Log.d("@dev", movies.toString())
        }

    private fun bindData(movies: List<Movie>){
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_tittle_1).text = movies[0].tittle
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
           val movie1: Movie? = viewModel.itemSelected(movies[0].id)
            movie1?.let {
                Log.d("@dev", "Pelicula seleccionada: ${it.tittle}")
            }
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_tittle_2).text = movies[1].tittle

        findViewById<TextView>(R.id.movie_tittle_3).text = movies[2].tittle
        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_tittle_4).text = movies[3].tittle
    }


    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

}
