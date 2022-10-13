package com.example.ooving4

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), MovieFragment.OnFragmentInteractionListener  {
    private var position: Int = 0
    private lateinit var movieFragment: MovieFragment
    private lateinit var movieDescriptionFragment: MovieDescriptionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieFragment = supportFragmentManager.findFragmentById(R.id.movie) as MovieFragment
        movieDescriptionFragment = supportFragmentManager.findFragmentById(R.id.movieDescription) as MovieDescriptionFragment
    }

    //To handle orientation of fragments. Using transactions.
    private fun setOrientation(config: Configuration) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT){
            findViewById<LinearLayout>(R.id.mainLinearView).orientation = LinearLayout.VERTICAL
        }else{
            findViewById<LinearLayout>(R.id.mainLinearView).orientation = LinearLayout.HORIZONTAL
        }
        transaction.commit()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setOrientation(newConfig)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.meny_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_next -> doNext()
            R.id.menu_prev -> doPrevious()
            else -> return false
        }
        return true
    }

    private fun doNext() {
        this.position++
        if(this.position > 4){
            this.position = 0
        }
        movieDescriptionFragment.setMovie(this.position)
        movieFragment.setSelected(this.position)
    }

    private fun doPrevious() {
        this.position--
        if(this.position < 0){
            this.position = 4
        }
        movieDescriptionFragment.setMovie(this.position)
        movieFragment.setSelected(this.position)
    }

    override fun onFragmentInteraction(position: Int) {
        val contentFragment = supportFragmentManager.findFragmentById(R.id.movieDescription) as MovieDescriptionFragment
        this.position = position
        contentFragment.setMovie(position)
    }
}




