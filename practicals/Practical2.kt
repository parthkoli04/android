package com.developernotfound.practicals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Practical2 : AppCompatActivity() {

    lateinit var num1 : EditText
    lateinit var num2 : EditText
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical2)


        num1 = findViewById(R.id.editTextNumberSigned)
        num2 = findViewById(R.id.editTextNumberSigned2)
        result = findViewById(R.id.textView2)
    }

    fun doAddition(view: View) {
        try{
            result.text = (num1.text.toString().toInt()+num2.text.toString().toInt()).toString()
        }
        catch (e:Exception)
        {
            result.text = "Error"
        }
    }

    fun doSubtraction(view: View) {
        try {
            result.text = (num1.text.toString().toInt()-num2.text.toString().toInt()).toString()
        }
        catch (e:Exception)
        {
            result.text= "Error"
        }
    }

    fun doDivision(view: View) {
        try {
            result.text = (num1.text.toString().toDouble()/num2.text.toString().toDouble()).toString()
        }
        catch (e:Exception)
        {
            result.text = "Error"
        }
    }

    fun doMultiplication(view: View) {
        try{
            result.text = (num1.text.toString().toInt()*num2.text.toString().toInt()).toString()
        }
        catch (e:Exception)
        {
            result.text = "Error"
        }
    }
}