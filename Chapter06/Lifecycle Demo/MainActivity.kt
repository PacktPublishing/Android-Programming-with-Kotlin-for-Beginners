package com.gamecodeschool.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "In onCreate",
                Toast.LENGTH_SHORT).show()

        Log.i("info", "In onCreate")

    }

    override fun onStart() {
        // First call the “official” version of this method
        super.onStart();

        Toast.makeText(this, "In onStart",
            Toast.LENGTH_SHORT).show();

        Log.i("info", "In onStart");
    }

    override fun onResume() {
        // First call the "official” version of this method
        super.onResume();

        Toast.makeText(this, "In onResume",
                Toast.LENGTH_SHORT).show();

        Log.i("info", "In onResume");
    }

    override fun onPause() {
        // First call the "official” version of this method
        super.onPause();

        Toast.makeText(this, "In onPause",
                Toast.LENGTH_SHORT).show();

        Log.i("info", "In onPause");
    }

    override fun onStop() {
        // First call the "official" version of this method
        super.onStop();

        Toast.makeText(this, "In onStop",
                Toast.LENGTH_SHORT).show();

        Log.i("info", "In onStop");
    }

    override fun onDestroy() {
        // First call the "official” version of this method
        super.onDestroy();

        Toast.makeText(this, "In onDestroy",
                Toast.LENGTH_SHORT).show();

        Log.i("info", "In onDestroy");
    }


}
