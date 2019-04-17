package com.gamecodeschool.basicclasses

import android.util.Log

class Soldier{

    // members
    var name = "Ryan"
    var rank = "Private"
    var missing = true

    var bullets = 100
        get() {
            Log.i("Getter being used","Value = $field")
            return field
        }
        set(value) {
            field = if (value < 0) 0 else value
            Log.i("Setter being used","New value = $field")
        }

    var packWeight = 150
    val gunWeight = 30
    var totalWeight = packWeight + gunWeight
        get() = packWeight + gunWeight


    // member function
    fun getStatus() {
        var status = "$rank $name"
        if(missing){
            status = "$status is missing!"
        }else{
            status = "$status ready for duty."
        }

        Log.i("Status",status)
    }


}