package com.developernotfound.practicals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class Practical4 : AppCompatActivity() {

    lateinit var contextButton : Button
    lateinit var popupbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical4)

        contextButton = findViewById(R.id.button6)
        popupbtn = findViewById(R.id.button7)

        registerForContextMenu(contextButton)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu1,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.addfriend -> Toast.makeText(this,"Add Friend",Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
            R.id.linkeddevices -> Toast.makeText(this,"Linked Devices",Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.mymenu2,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.option1 -> Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show()
            R.id.option2 -> Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show()
            R.id.option3 -> Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show()
        }

        return super.onContextItemSelected(item)
    }

    fun openPopup(view: View) {
        var popupm = PopupMenu(this, popupbtn)
        popupm.inflate(R.menu.mymenu2)
        popupm.show()

        popupm.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener
        { item : MenuItem ->
            when (item.itemId)
            {
                R.id.option1 -> Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show()
                R.id.option2 -> Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show()
                R.id.option3 -> Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show()

                else -> {}
            }
            true
        })

    }

}