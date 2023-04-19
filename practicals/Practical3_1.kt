package com.developernotfound.practicals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Practical3_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical3_1)

        val bundle : Bundle? = intent.extras

        var name : TextView = findViewById(R.id.textView6)
        var gender : TextView = findViewById(R.id.textView7)
        var languages : TextView = findViewById(R.id.textView8)
        var batch : TextView = findViewById(R.id.textView9)
        var country : TextView = findViewById(R.id.textView10)

        name.text = bundle?.getString("name","None")
        gender.text = bundle?.getString("gender","Others")
        languages.text = bundle?.getString("languages","None")
        batch.text = bundle?.getString("batch","None")
        country.text = bundle?.getString("country","None")

    }
}