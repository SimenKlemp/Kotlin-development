package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(meny: Menu): Boolean{
        super.onCreateOptionsMenu(meny)
        meny.add("Simen")
        meny.add("Klemp")
        Log.d("INFT2501","meny laget") //vises i LogCat
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title.equals("Simen")) {
            Log.w("Leksjon", "Simen er trykket av brukeren")
        }
        else {
            Log.e("Leksjon", "Klemp er trykket av brukeren")

        }
        return true // hvorfor true her? Se API-dokumentasjonen!!
    }

}

