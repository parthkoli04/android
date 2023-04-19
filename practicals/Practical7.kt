package com.developernotfound.practicals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Practical7 : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practical7)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener{
            when (it.itemId)
            {
                R.id.option1 -> Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show()
                R.id.option2 -> Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show()
                R.id.option3 -> Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}