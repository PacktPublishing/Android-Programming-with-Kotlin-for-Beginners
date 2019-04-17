package com.gamecodeschool.helloworld

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_hello_world.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action",
                    Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        // Your code goes here
        Toast.makeText(this, "Can you see me?",
                Toast.LENGTH_SHORT).show()

        Log.i("info", "Done creating the app")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_hello_world, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun topClick(v: View) {
        Toast.makeText(this, "Top button clicked",
                Toast.LENGTH_SHORT).show()

        Log.i("info", "The user clicked the top button")
    }

    fun bottomClick(v: View) {
        Toast.makeText(this, "Bottom button clicked",
                Toast.LENGTH_SHORT).show()

        Log.i("info", "The user clicked the bottom button")
    }

}

