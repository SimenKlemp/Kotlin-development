package com.example.ooving2test

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : Activity() {
    private val requestCode: Int = 1
    private var randomNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        val max = 100
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent("ooving2Oppgave1.DisplayRandomNumber")
        intent.putExtra("max", max)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode != RESULT_OK) {
            Log.e("onActivityResult()", "Noe gikk galt")
            return
        }
        if (requestCode == requestCode) {
            randomNumber = data.getIntExtra("value", randomNumber)
            val numberValue = findViewById<View>(R.id.numberView) as TextView
            numberValue.setText(randomNumber.toString())

        }
    }
}