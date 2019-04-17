package com.gamecodeschool.simplefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a new fragment using the manager
        var frag = supportFragmentManager
                .findFragmentById(R.id.fragmentHolder)

        // Check the fragment has not already been initialized
        if (frag == null) {
            // Initialize the fragment based on our SimpleFragment
            frag = SimpleFragment()
                supportFragmentManager.beginTransaction()
                        .add(R.id.fragmentHolder, frag)
                        .commit()
        }
    }
}
