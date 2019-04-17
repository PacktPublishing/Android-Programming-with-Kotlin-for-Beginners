package com.gamecodeschool.inheritanceexamples

import android.util.Log

open class Soldier() {

    open fun shoot () {
        Log.i("Action","Bang bang bang")
    }
}