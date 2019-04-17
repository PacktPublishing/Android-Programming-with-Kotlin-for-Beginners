package com.gamecodeschool.basicclasseswithinheritance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
        friendlyDestroyer.takeDamage(enemyDestroyer.attack())
        friendlyDestroyer.takeDamage(enemyCarrier.attack())
        enemyCarrier.takeDamage(friendlyCarrier.attack())
        enemyCarrier.takeDamage(friendlyDestroyer.attack())

        // Take stock of the supplies situation
        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        // Dock at the shipyard
        friendlyShipyard.serviceShip(friendlyCarrier)
        friendlyShipyard.serviceShip(friendlyDestroyer)

        // Take stock of the supplies situation
        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        // Finish off the enemy
        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
        enemyDestroyer.takeDamage(friendlyCarrier.attack())
        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
    }
}
