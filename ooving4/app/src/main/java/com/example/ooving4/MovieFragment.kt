package com.example.ooving4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

class MovieFragment: Fragment() {
    private var mListener: OnFragmentInteractionListener? = null
    private var movies: Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movies = resources.getStringArray(R.array.movies)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.movie_fragment, container, false);

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }

    private fun initList() {
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_activated_1, movies)
        val listView = requireView().findViewById<ListView>(R.id.movieList)
        listView.adapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent: AdapterView<*>?, valgt: View, position: Int, id: Long ->
                mListener?.onFragmentInteraction(position)
            }

    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(position: Int)
    }


    fun setSelected(position: Int){
        val listView = requireView().findViewById<ListView>(R.id.movieList)
        listView.setItemChecked(position, true)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = try {
            activity as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "$activity must implement OnFragmentInteractionListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}

