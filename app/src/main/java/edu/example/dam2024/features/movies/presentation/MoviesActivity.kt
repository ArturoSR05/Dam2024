package edu.example.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import edu.example.dam2024.R
import edu.example.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.example.dam2024.features.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movies)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        val movies = viewModel.viewCreated()
        bindData(movies)

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

    private fun testListXml(){
        val movies = viewModel.viewCreated()
        val xmlDataSource = MovieXmlLocalDataSource(this)
        xmlDataSource.saveAll(movies)

        val moviesFromXml = xmlDataSource.findAll()
        Log.d("@dev", moviesFromXml.toString())
    }

    private fun testMovie(){
        val movies = viewModel.viewCreated()
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = xmlDataSource.findById("1")
        Log.d("@dev", "$movie")
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
