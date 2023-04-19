package com.developernotfound.practicals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class Practical6 : AppCompatActivity() {
    lateinit var listview : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical6)

        listview = findViewById(R.id.myListView)

        var items = arrayOf("Print","The","Program","Hello","World","In","Python","Programming","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language","Language")

        var adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)

        listview.setAdapter(adapter1)

        listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            when (i)
            {
                0 -> Log.d("MSG","0")
                1 -> Log.d("MSG","1")
                2 -> Log.d("MSG","2")
                3 -> Log.d("MSG","3")
                4 -> Log.d("MSG","4")
                5 -> Log.d("MSG","5")

                else -> {}
            }
        }
    }

}