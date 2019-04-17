package com.gamecodeschool.inheritanceexamples

import android.util.Log

class Sniper: Soldier(){
    // He forget to bring enough ammo
    var sniperAmmo = 3

    override fun shoot(){
        when (sniperAmmo > 0) {
            true -> {
                Log.i("Action", "Steady… Adjust for wind… Bang.")
                sniperAmmo--;
            }
            false -> super.shoot()
        }
    }

    fun getIntoPosition(){
        Log.i("Action","Preparing line of sight to target")
    }
}