package com.gamecodeschool.basicclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friendlyDestroyer = Destroyer("Invincible")
        val friendlyCarrier = Carrier("Indomitable")

        val enemyDestroyer = Destroyer("Grey Death")
        val enemyCarrier = Carrier("Big Grey Death")

        val friendlyShipyard = ShipYard()

        // A small battle
        friendlyDestroyer.takeDamage(enemyDestroyer.shootShell())
        friendlyDestroyer.takeDamage(enemyCarrier.launchAerialAttack())
        enemyCarrier.takeDamage(friendlyCarrier.launchAerialAttack())
        enemyCarrier.takeDamage(friendlyDestroyer.shootShell())

        // Take stock of the supplies situation
        Log.d("${friendlyDestroyer.name} ammo = ",
        "${friendlyDestroyer.ammo}")

        Log.d("${friendlyCarrier.name} attacks = ",
                "${friendlyCarrier.attacksRemaining}")

        // Dock at the shipyard
        friendlyShipyard.serviceCarrier(friendlyCarrier)
        friendlyShipyard.serviceDestroyer(friendlyDestroyer)

        // Take stock of the supplies situation
        Log.d("${friendlyDestroyer.name} ammo = ",
                "${friendlyDestroyer.ammo}")

        Log.d("${friendlyCarrier.name} attacks = ",
                "${friendlyCarrier.attacksRemaining}")


        // Finish off the enemy
        enemyDestroyer.takeDamage(friendlyDestroyer.shootShell())
        enemyDestroyer.takeDamage(friendlyCarrier.launchAerialAttack())
        enemyDestroyer.takeDamage(friendlyDestroyer.shootShell())

    }
}
