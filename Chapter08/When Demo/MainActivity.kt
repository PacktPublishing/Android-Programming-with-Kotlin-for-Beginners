package com.gamecodeschool.whendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val time = 9

        val amOrPM = if (time < 12) {
            "am"
        } else {
            "pm"
        }

        Log.i("It is ", amOrPM)

        val weight = 30
        val instruction = "Put this bag in the ${if (weight >= 25) "hold" else "cabin"}"
        Log.i("instruction is ", instruction)

        var isComingOverTheBridge: Boolean
        var enemyTroops: Int
        var friendlyTroops: Int
        var wavingWhiteFlag: Boolean

        isComingOverTheBridge = true;
        enemyTroops = 10;
        friendlyTroops = 5;
        wavingWhiteFlag = false;


        if (!wavingWhiteFlag) {

            // not surrendering so check everything else

            if (isComingOverTheBridge && friendlyTroops >= enemyTroops) {

                // shoot them
            } else if (isComingOverTheBridge && friendlyTroops <
                    enemyTroops) {

                // blow the bridge

            }

        } else {

            // this is the else for our first if
            // Take prisoners

        }

        // Holding position

        // Change the value that rating is initialized to between 1 and 5
        val rating:Int = 4
        when (rating) {
            1 -> Log.i("Oh dear! Rating = ", "$rating stars")
            2 -> Log.i("Not good! Rating = ", "$rating stars")
            3 -> Log.i("Not bad! Rating = ", "$rating stars")
            4 -> Log.i("This is good! Rating = ", "$rating stars")
            5 -> Log.i("Amazing! Rating = ", "$rating stars")

            else -> {
                print("Error - Invalid rating")
                Log.i("Error:", "$rating is not a valid rating")
            }
        }

        // Enter an ocean, river or breed of dog
        val name:String = "Nile"
        when (name) {
            "Atlantic","Pacific", "Arctic" ->
                Log.i("Found:", "$name is an ocean")

            "Thames","Nile", "Mississippi" ->
                Log.i("Found:", "$name is a river")

            "Labrador","Beagle", "Jack Russel" ->
                Log.i("Found:", "$name is a dog")

            else -> {
                Log.i("Not found:", "$name is not in database")
            }
        }



    }




}
