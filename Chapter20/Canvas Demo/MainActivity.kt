package com.gamecodeschool.canvasdemo

import android.app.Activity
import android.os.Bundle
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.ImageView


class MainActivity : Activity() {

    // Here are all the objects(instances)
    // of classes that we need to do some drawing
    lateinit var myImageView: ImageView
    lateinit var myBlankBitmap: Bitmap
    lateinit var myCanvas: Canvas
    lateinit var myPaint: Paint


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize all the objects ready for drawing
        // We will do this inside the onCreate method
        val widthInPixels = 800
        val heightInPixels = 600

        // Create a new Bitmap
        myBlankBitmap = Bitmap.createBitmap(widthInPixels,
                heightInPixels,
                Bitmap.Config.ARGB_8888)

        // Initialize the Canvas and associate it
        // with the Bitmap to draw on
        myCanvas = Canvas(myBlankBitmap)

        // Initialize the ImageView and the Paint
        myImageView = ImageView(this)
        myPaint = Paint()
        // Draw on the Bitmap
        // Wipe the Bitmap with a blue color
        myCanvas.drawColor(Color.argb(255, 0, 0, 255));

        // Re-size the text
        myPaint.textSize = 100f
        // Change the paint to white
        myPaint.color = Color.argb(255, 255, 255, 255)
        // Draw some text
        myCanvas.drawText("Hello World!",100f, 100f, myPaint)

        // Change the paint to yellow
        myPaint.color = Color.argb(255, 212, 207, 62)
        // Draw a circle
        myCanvas.drawCircle(400f,250f, 100f, myPaint)

        // Associate the drawn upon Bitmap with the ImageView
        myImageView.setImageBitmap(myBlankBitmap)
        // Tell Android to set our drawing
        // as the view for this app
        // via the ImageView
        setContentView(myImageView)



    }
}
