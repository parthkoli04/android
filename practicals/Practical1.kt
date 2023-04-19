package com.developernotfound.practicals

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class Practical1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical1)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MSG","Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MSG","Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MSG","Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MSG","Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MSG","Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MSG","Destroy")
    }

    fun openCalci(view: View)
    {
        val intent = Intent(this@Practical1,Practical2::class.java)
        startActivity(intent)
    }

    fun doImplicitIntent(view: View)
    {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
        startActivity(intent)
    }

    fun openForm(view: View)
    {
        val intent = Intent(this@Practical1,Practical3::class.java)
        startActivity(intent)
    }

    fun openMenu(view: View) {
        val intent = Intent(this@Practical1,Practical4::class.java)
        startActivity(intent)
    }

    fun openDB(view: View) {
        val intent = Intent(this@Practical1,Practical5::class.java)
        startActivity(intent)
    }

    fun openListview(view: View) {
        val intent = Intent(this@Practical1,Practical6::class.java)
        startActivity(intent)
    }

    fun openNavView(view: View)
    {
        val intent = Intent(this@Practical1,Practical7::class.java)
        startActivity(intent)
    }

    fun openNotify(view: View) {
        val intent = Intent(this,Practical8::class.java)
        startActivity(intent)
    }
}