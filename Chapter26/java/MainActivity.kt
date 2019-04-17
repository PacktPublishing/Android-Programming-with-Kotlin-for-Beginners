package com.gamecodeschool.agedatabase

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        // Create a transaction
        val transaction = supportFragmentManager.beginTransaction()
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_insert -> {
                // Create a new fragment of the appropriate type
                val fragment = InsertFragment()
                // What to do and where to do it
                transaction.replace(R.id.fragmentHolder, fragment)
            }
            R.id.nav_search -> {
                val fragment = SearchFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }
            R.id.nav_delete -> {
                val fragment = DeleteFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }
            R.id.nav_results -> {
                val fragment = ResultsFragment()
                transaction.replace(R.id.fragmentHolder, fragment)
            }

        }

        // Ask Android to remember which
        // menu options the user has chosen
        transaction.addToBackStack(null);

        // Implement the change
        transaction.commit();

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
