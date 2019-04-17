package com.gamecodeschool.basicclasseswithinheritance

import android.util.Log

class ShipYard {
    fun serviceShip(shipToBeServiced: Ship){
        shipToBeServiced.serviceShip()
        Log.i("Servicing","${shipToBeServiced.name}")
    }
}