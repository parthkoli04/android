package com.developernotfound.practicals

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Practical5 : AppCompatActivity() {

    lateinit var db : SQLiteDatabase
    lateinit var name : EditText
    lateinit var batch : EditText
    lateinit var grade : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical5)

        name = findViewById(R.id.editTextTextPersonName3)
        batch = findViewById(R.id.editTextTextPersonName4)
        grade = findViewById(R.id.editTextTextPersonName5)

        db = openOrCreateDatabase("myDB",Context.MODE_PRIVATE,null)

        db.execSQL("delete from studs")

        db.execSQL("create table if not exists studs(id integer primary key autoincrement, name varchar,batch varchar, grade varchar)")
    }

    fun doInsert(view: View) {

        try {
            db.execSQL("insert into studs(name,batch,grade) values ('${name.text.toString()}','${batch.text.toString()}','${grade.text.toString()}')")

            Toast.makeText(this@Practical5, "Inserted Successfully!", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception)
        {
            Log.d("DB",e.toString())
        }

    }

    fun doRead(view: View){
        try {

        var cursor: Cursor = db.rawQuery("select * from studs",null)

        var myString = StringBuilder(40)

        while (cursor.moveToNext())
        {
            myString.append("Name: ${cursor.getString(1)}\nBatch: ${cursor.getString(2)}\nGrade: ${cursor.getString(3)}")
        }

            Toast.makeText(this@Practical5, "$myString", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception)
        {
            Log.d("DB",e.toString())
        }
    }

    fun doSearch(view: View) {
        try {
            var cursor : Cursor = db.rawQuery("select * from studs where name='${name.text.toString()}'",null)

            cursor.moveToFirst()

            Toast.makeText(this@Practical5, "Name: ${cursor.getString(1)}\nBatch: ${cursor.getString(2)}\nGrade: ${cursor.getString(3)}", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception)
        {
            Log.d("DB",e.toString())
        }
    }

    fun doUpdate(view: View) {
        try {
            var cursor : Cursor = db.rawQuery("select * from studs where name='${name.text.toString()}'",null)

            cursor.moveToFirst()

            db.execSQL("update studs set name='${name.text.toString()}',batch='${batch.text.toString()}',grade='${grade.text.toString()}'")

            Toast.makeText(this@Practical5, "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception)
        {
            Log.d("DB",e.toString())
        }

    }

    fun doDelete(view: View) {
        try {
            db.execSQL("delete from studs where name='${name.text.toString()}'")

            Toast.makeText(this@Practical5, "Deleted Successfully!", Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception)
        {
            Log.d("DB",e.toString())
        }

    }




}