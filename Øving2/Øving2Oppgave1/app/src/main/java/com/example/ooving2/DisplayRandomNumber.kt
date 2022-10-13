package com.example.ooving2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class DisplayRandomNumber : Activity() {
    private var max = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        max = intent.getIntExtra("max", max)

        val randomValue = (0..max).random()
        Toast.makeText(this, randomValue.toString(), Toast.LENGTH_LONG).show()
        setResult(RESULT_OK, Intent().putExtra("value", randomValue))
        finish()
    }
}