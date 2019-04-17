package com.gamecodeschool.dynamicarrayexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring and allocating in one step
        val ourArray = IntArray(1000)

        // Let's initialize ourArray using a for loop
        // Because more than a few variables is allot of typing!

        for (i in 0..999) {

            // Put the value of our value into ourArray
            // At the position decided by i.
            ourArray[i] = i * 5

            //Output what is going on
            Log.i("info", "i = $i")
            Log.i("info", "ourArray[i] = ${ ourArray[i]}")
        }

    }
}
