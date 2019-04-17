package com.gamecodeschool.basicclasses

import android.util.Log

class Destroyer(name: String) {
    // What is the name of this ship
    var name: String = ""
        private set

    // What type of ship is it
    // Always a destroyer
    val type = "Destroyer"

    // How much the ship can take before sinking
    private var hullIntegrity = 200

    // How many shots left in the arsenal
    var ammo = 1
    // Cannot be directly set externally
        private set

    // No external access whatsoever
    private var shotPower = 60

    // Has the ship been sunk
    private var sunk = false

    // This code runs as the instance is being initialized
    init {
        // So we can use the name parameter
        this.name = "$type $name"
    }

    // Anything can use this function
    fun takeDamage(damageTaken: Int) {
        if (!sunk) {
            hullIntegrity -= damageTaken
            Log.d("$name damage taken =","$damageTaken")
            Log.d("$name hull integrity =","$hullIntegrity")

            if (hullIntegrity <= 0) {
                Log.d("Destroyer", "$name has been sunk")
                sunk = true
            }
        } else {
            // Already sunk
            Log.d("Error", "Ship does not exist")
        }
    }

    // Return a different value dependent
    // on the when expression
    fun shootShell():Int {
        // Let the calling code no how much damage to do
        return if (ammo > 0) {
            ammo--
            shotPower
        }else{
            0
        }
    }

    fun serviceShip() {
        ammo = 10
        hullIntegrity = 100
    }

}