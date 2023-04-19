package com.developernotfound.practicals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

class Practical3 : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var genders : RadioGroup
    lateinit var english : CheckBox
    lateinit var hindi : CheckBox
    lateinit var marathi : CheckBox
    lateinit var batch : AutoCompleteTextView
    lateinit var country : Spinner
    lateinit var pass1 : EditText
    lateinit var pass2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical3)

        name = findViewById(R.id.editTextTextPersonName)
        genders = findViewById(R.id.radioGroup)
        english = findViewById(R.id.checkBox)
        hindi = findViewById(R.id.checkBox2)
        marathi = findViewById(R.id.checkBox3)
        batch = findViewById(R.id.autoCompleteTextView)
        country = findViewById(R.id.spinner)
        pass1 = findViewById(R.id.editTextTextPassword)
        pass2 = findViewById(R.id.editTextTextPassword2)

        var batches = arrayOf("FYCS", "SYCS", "TYCS")
        var countries = arrayOf("India", "Japan", "Israel", "Russia", "USA")

        var adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, batches)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)

        batch.setAdapter(adapter1)
        country.setAdapter(adapter2)

        batch.threshold = 1

        batch.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this@Practical3,batches[position].toString(),Toast.LENGTH_SHORT).show()
        }

        country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var myCountry = countries[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                var myCountry = "None"
            }
        }
    }

    fun onSubmit(view: View)
    {
        if (pass1.text.toString().equals(pass2.text.toString()) && pass1.text.toString().isNotEmpty())
        {

        val intent = Intent(this@Practical3,Practical3_1::class.java)

        intent.putExtra("name",name.text.toString())

        var gender = when(genders.checkedRadioButtonId)
        {
            R.id.radioButton -> "Male"
            R.id.radioButton2 -> "Female"
            else -> "Others"
        }

        intent.putExtra("gender",gender)

        var languages = StringBuilder(40)

        if (english.isChecked){
            languages.append(english.text.toString())
        }

        if (hindi.isChecked)
        {
            languages.append(hindi.text.toString())
        }

        if (marathi.isChecked)
        {
            languages.append(marathi.text.toString())
        }

        intent.putExtra("languages",languages.toString())

        intent.putExtra("batch",batch.text.toString())

        intent.putExtra("country",country.selectedItem.toString())

            Toast.makeText(this,"Successfully Submitted",Toast.LENGTH_SHORT).show()

        startActivity(intent)
        }
        else
        {
            Toast.makeText(this,"Invalid Password",Toast.LENGTH_SHORT).show()
        }

    }
}
