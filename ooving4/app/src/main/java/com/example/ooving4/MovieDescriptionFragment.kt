package com.example.ooving4
import android.content.res.TypedArray
import android.graphics.ImageFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

class MovieDescriptionFragment: Fragment() {
    private var movieTitles: Array<String> = arrayOf()
    private var movieDescriptions: Array<String> = arrayOf()
    private var moviePictures: TypedArray? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_description_fragment, container, false);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDescriptions = resources.getStringArray(R.array.movieDescriptions)
        movieTitles = resources.getStringArray(R.array.movies)
        moviePictures = resources.obtainTypedArray(R.array.moviePictures)
    }

    fun setMovie(position: Int){
        requireView().findViewById<TextView>(R.id.movieTitle).text = movieTitles[position]
        requireView().findViewById<ImageView>(R.id.moviePictureView).setImageDrawable(moviePictures?.getDrawable(position))
        requireView().findViewById<TextView>(R.id.movieDescriptionText).text = movieDescriptions[position]
    }
}