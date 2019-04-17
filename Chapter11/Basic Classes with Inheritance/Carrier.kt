package com.gamecodeschool.basicclasseswithinheritance

class Carrier (name: String): Ship(
        name,
        "Carrier",
        20,
        100){

    // No external access whatsoever
    private var attackPower = 120

    override fun attack(): Int {
        // Let the calling code no how much damage to do
        return if (attacksRemaining > 0) {
            attacksRemaining--
            attackPower
        }else{
            0
        }
    }
}