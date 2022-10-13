package com.example.ooving2del2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class DisplayRandomNumber: Activity() {
    private var max = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        max = intent.getIntExtra("max", max)

        val randomValue = (0..max).random()
        Toast.makeText(this, randomValue.toString(), Toast.LENGTH_LONG).show()
        setResult(Activity.RESULT_OK, Intent().putExtra("value", randomValue))
        finish()
    }
}