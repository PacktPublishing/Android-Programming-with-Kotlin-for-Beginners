package com.gamecodeschool.functiondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val firstName = "Gabe"
        val secondName = "Newell"

        // Call function using literal String
        printName("Sid","Meier")

        // Call using String variables
        printName(firstName, secondName)

        // If a circle has a radius of 3
        // What is the area
        printAreaCircle(3f)

        // Returned value is discarded
        getSum(10, 10)

        // Returned value is stored in answer
        val answer  = getSum(10, 10)

        // Print out the returned value
        Log.i("Returned value =","${getSum(10, 10)}")

        // Use the returned value in another function call
        printAreaCircle(getSum(1,2).toFloat())

        Log.i("Returned area =","${getAreaCircle(3f)}")
        Log.i("Returned name =","${getName("Alan","Turing")}")

        printUpTo3(1)
        printUpTo3(2)
        printUpTo3(3)
        printUpTo3(4)

        orderProduct(product ="Beer")
        orderProduct(true, product ="Porsche")
        orderProduct(true, product ="Barbie (Jet-Set Edition)", postalService = "Next Day")
        orderProduct(false, product ="Flat-pack bookcase", postalService = "Carrier Pigeon")
    }

    fun printName(first: String, second:String){
        Log.i("Joined Name =","$first $second")
    }

    fun printAreaCircle(radius: Float){
        Log.i("Area =","${3.14 * (radius *radius)}")
    }

    fun getSum(a: Int, b: Int): Int {
        return a + b
    }

    fun getAreaCircle(radius: Float): Float{
        return 3.14f * (radius * radius)
    }

    fun getName(first: String, second: String): String{
        return "$first $second"
    }

    fun printUpTo3(aNumber: Int){ // No return type!
        if(aNumber > 3){
            Log.i("aNumber is","TOO BIG! - Didn't you read my name")
            return // Going back to the calling code
        }

        Log.i("aNumber is","$aNumber")
    }

    fun orderProduct(giftWrap: Boolean = false,
                     product: String,
                     postalService: String = "Standard") {

        var details: String =""

        if (giftWrap) {
            details += "Gift wrapped "
        }

        details += "$product "
        details += "by $postalService postage"

        Log.i("Product details",details)
    }

}
