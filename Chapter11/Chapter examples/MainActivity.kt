package com.gamecodeschool.inheritanceexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soldier = Soldier()
        soldier.shoot()

        val specialForces = SpecialForces()
        specialForces.shoot()
        specialForces.SneakUpOnEnemy()

        val paratrooper = Paratrooper()
        paratrooper.shoot()
        paratrooper.jumpOutOfPlane()

        val sniper = Sniper()
        sniper.getIntoPosition()
        sniper.shoot()
        sniper.shoot()
        sniper.shoot()
        sniper.shoot()

    }
}
