package com.gamecodeschool.loopsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var y = 10
        do {
            y++
            Log.i("In the do block and y=","$y")
        }
        while(y < 10)

        // We could do this...
        // val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        // It is much quicker to do this...
        val list = 1..10
        for (i in list)
            Log.i("Looping through list","Current value is $i")




        var countDown = 10
        while(countDown > 0){

            if(countDown == 5)break

            Log.i("countDown =","$countDown")
            countDown --
        }

        var countUp = 0
        while(countUp < 10){
            countUp++

            if(countUp > 5)continue

            Log.i("Inside loop","countUp = $countUp")
        }

        Log.i("Outside loop","countUp = $countUp")



    }
}
