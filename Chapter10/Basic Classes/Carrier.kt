package com.gamecodeschool.basicclasses

import android.util.Log

class Carrier (name: String){
    // What is the name of this ship
    var name: String = ""
        private set

    // What type of ship is it
    // Always a destroyer
    val type = "Carrier"

    // How much the ship can take before sinking
    private var hullIntegrity = 100

    // How many shots left in the arsenal
    var attacksRemaining = 1
    // Cannot be directly set externally
        private set

    // No external access whatsoever
    private var attackPower = 120

    // Has the ship been sunk
    private var sunk = false

    // This code runs as the instance is being initialized
    init {
        // So we can use the name parameter
        this.name = "$type $name"
    }

    // Anything call use this function
    fun takeDamage(damageTaken: Int) {
        if (!sunk) {
            hullIntegrity -= damageTaken
            Log.d("$name damage taken =","$damageTaken")
            Log.d("$name hull integrity =","$hullIntegrity")

            if (hullIntegrity <= 0) {
                Log.d("Carrier", "$name has been sunk")
                sunk = true
            }
        } else {
            // Already sunk
            Log.d("Error", "Ship does not exist")
        }
    }

    // Return a different value dependent
    // on the when expression
    fun launchAerialAttack() :Int {
        // Let the calling code no how much damage to do
        return if (attacksRemaining > 0) {
            attacksRemaining--
            attackPower
        }else{
            0
        }
    }

    fun serviceShip() {
        attacksRemaining = 20
        hullIntegrity = 200
    }
}