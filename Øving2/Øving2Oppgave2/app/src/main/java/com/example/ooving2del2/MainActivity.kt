package com.example.ooving2del2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    var firstNumber = 0
    var secondNumber = 0
    val firstRequestCode = 1
    val secondRequestCode = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun checkEquationMultiply(v: View?){
        val firstNumber = findViewById<TextView>(R.id.firstNumber).text.toString().toInt()
        val secondNumber = findViewById<TextView>(R.id.secondNumber).text.toString().toInt()
        val userAnswer = findViewById<TextView>(R.id.userAnswer).text.toString().toInt()
        val realAnswer = firstNumber * secondNumber
        var wrongAnswer = getString(R.string.feil) + " " + realAnswer

        if(userAnswer == realAnswer) {
            val textAnswer = findViewById<View>(R.id.textAnswer) as TextView
            textAnswer.setText(R.string.riktig)
            //Toast.makeText(this, R.string.riktig, Toast.LENGTH_LONG).show()
        }
        else{
            val textAnswer = findViewById<View>(R.id.textAnswer) as TextView
            textAnswer.setText(wrongAnswer)
            //Toast.makeText(this, wrongAnswer, Toast.LENGTH_LONG).show()
        }
        getRandomNumbers()
    }

    fun checkEquationAddition(v: View?){
        val firstNumber = findViewById<TextView>(R.id.firstNumber).text.toString().toInt()
        val secondNumber = findViewById<TextView>(R.id.secondNumber).text.toString().toInt()
        val userAnswer = findViewById<TextView>(R.id.userAnswer).text.toString().toInt()
        val realAnswer = firstNumber + secondNumber
        var wrongAnswer = getString(R.string.feil) + " " + realAnswer

        if(userAnswer == realAnswer) {
            val textAnswer = findViewById<View>(R.id.textAnswer) as TextView
            textAnswer.setText(R.string.riktig)
            //Toast.makeText(this, R.string.riktig, Toast.LENGTH_LONG).show()
        }
        else{
            val textAnswer = findViewById<View>(R.id.textAnswer) as TextView
            textAnswer.setText(wrongAnswer)
            //Toast.makeText(this, wrongAnswer, Toast.LENGTH_LONG).show()
        }
        getRandomNumbers()
    }

    fun getRandomNumbers(){
        val intent = Intent("DisplayRandomNumber")
        intent.putExtra("max", findViewById<TextView>(R.id.upperLimit).text.toString().toInt())
        startActivityForResult(intent, firstRequestCode)
        startActivityForResult(intent, secondRequestCode)

    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode != RESULT_OK) {
            Log.e("onActivityResult()", "Noe gikk galt")
            return
        }
        if (requestCode == firstRequestCode) {
            firstNumber = data.getIntExtra("value", firstNumber)
            val textView = findViewById<TextView>(R.id.firstNumber)
            textView.text = firstNumber.toString()
        }else if(requestCode == secondRequestCode) {
            secondNumber = data.getIntExtra("value", secondNumber)
            val textView = findViewById<TextView>(R.id.secondNumber)
            textView.text = secondNumber.toString()
        }
    }

}