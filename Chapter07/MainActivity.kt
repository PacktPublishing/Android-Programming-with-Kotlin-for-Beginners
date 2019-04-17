package com.gamecodeschool.expressyourself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = "Nolan Bushnell"
        val yearOfBirth = 1943
        var currentYear = 2019
        var age: Int

        age = currentYear - yearOfBirth
        Log.i("info", "$age")
        currentYear ++;
        Log.i("info","$name was born in $yearOfBirth and is $age years old. Next year he will be ${currentYear - yearOfBirth} years old)")

    }
}
