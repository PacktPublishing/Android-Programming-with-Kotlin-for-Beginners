package com.gamecodeschool.inheritanceexamples

import android.util.Log

class Paratrooper: Soldier() {
    fun jumpOutOfPlane() {
        Log.i("Action", "Jump out of plane")
    }
}