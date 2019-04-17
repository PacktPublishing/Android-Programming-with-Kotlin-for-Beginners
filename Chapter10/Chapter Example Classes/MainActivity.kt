package com.gamecodeschool.basicclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // First declare an instance of Soldier called soldier1
        val soldier1 = Soldier()
        soldier1.getStatus()

        // Now access and print each of the variables
        Log.i("Name =","${soldier1.name}")
        Log.i("Rank =","${soldier1.rank}")
        Log.i("Missing =","${soldier1.missing}")

        // Mission to rescue Private Ryan succeeds
        soldier1.missing = false;

        // Ryan behaved impeccably
        soldier1.rank = "Private First Class"

        // Now access and print each of the variables
        Log.i("Name =","${soldier1.name}")
        Log.i("Rank =","${soldier1.rank}")
        Log.i("Missing =","${soldier1.missing}")

        // In onCreate or some other function/class from our app
        // Create a new instance of the Soldier class
        val soldier = Soldier()
        // Access the value of bullets
        Log.i("bullets = ","${soldier.bullets}")// Code in getter will execute
        soldier.bullets--
        Log.i("bullets =","${soldier.bullets}")// Code in setter will execute


        // Create a soldier
        val strongSoldier = Soldier()
        // Print out the totalWeight value
        Log.i("totalWeight =","${strongSoldier.totalWeight}")

        // Change the value of packWeight
        strongSoldier.packWeight = 300
        // Print out the totalWeight value again
        Log.i("totalWeight =","${strongSoldier.totalWeight}")



        var satelliteController = SatelliteController()






        // This still doesn't work which is what we want
        // satelliteController.gpsCoordinates = "1.2345, 5.6789"

        // But this will print the gpsCoordinates
        Log.i("Coords=","$satelliteController.gpsCoordinates")


        // Instantiate a Book using the primary constructor
        val book = Book("Animal Farm", 20000000)


        // Book two meetings
        // First when we don't yet know the time
        val meeting = Meeting("Thursday", "Bob")

        // And secondly when we do know the time
        val anotherMeeting = Meeting("Wednesday","Dave","3 PM")


    }
}
