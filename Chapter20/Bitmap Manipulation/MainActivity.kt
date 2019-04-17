package com.gamecodeschool.bitmapmanipulation

import android.app.Activity
import android.graphics.*
import android.os.Bundle
import android.widget.ImageView
import android.graphics.Bitmap

class MainActivity : Activity() {

    // Here are all the objects(instances)
    // of classes that we need to do some drawing
    lateinit var myImageView: ImageView
    lateinit var myBlankBitmap: Bitmap
    lateinit var bobBitmap: Bitmap
    lateinit var myCanvas: Canvas
    lateinit var myPaint: Paint


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize all the objects ready for drawing
        val widthInPixels = 2000
        val heightInPixels = 1000

        // Create a new Bitmap
        myBlankBitmap = Bitmap.createBitmap(widthInPixels,
                heightInPixels,
                Bitmap.Config.ARGB_8888)

        // Initialize Bob
        bobBitmap = BitmapFactory.decodeResource(
                resources, R.drawable.bob)

        // Initialize the Canvas and associate it
        // with the Bitmap to draw on
        myCanvas = Canvas(myBlankBitmap)

        // Initialize the ImageView and the Paint
        myImageView = ImageView(this)
        myPaint = Paint()

        // Draw on the Bitmap
        // Wipe the Bitmap with a blue color
        myCanvas.drawColor(Color.argb(
                255, 0, 0, 255))

        // Draw some bitmaps
        drawRotatedBitmaps()
        drawEnlargedBitmap()
        drawShrunkenBitmap()

        // Associate the drawn upon Bitmap
        // with the ImageView
        myImageView.setImageBitmap(myBlankBitmap)
        // Tell Android to set our drawing
        // as the view for this app
        // via the ImageView
        setContentView(myImageView)


    }

    fun drawRotatedBitmaps() {
        var rotation = 0f
        var horizontalPosition = 350
        var verticalPosition = 25
        val matrix = Matrix()

        var rotatedBitmap: Bitmap

        rotation = 0f
        while (rotation < 360) {
            matrix.reset()
            matrix.preRotate(rotation)

            rotatedBitmap = Bitmap
                    .createBitmap(bobBitmap,
                            0, 0, bobBitmap.width - 1,
                            bobBitmap.height - 1,
                            matrix, true)

            myCanvas.drawBitmap(
                    rotatedBitmap,
                    horizontalPosition.toFloat(),
                    verticalPosition.toFloat(),
                    myPaint)

            horizontalPosition += 120
            verticalPosition += 70
            rotation += 30f
        }
    }

    fun drawEnlargedBitmap() {
        bobBitmap = Bitmap
                .createScaledBitmap(bobBitmap,
                        300, 400, false)
        myCanvas.drawBitmap(bobBitmap, 25f, 25f, myPaint)

    }

    fun drawShrunkenBitmap() {
        bobBitmap = Bitmap
                .createScaledBitmap(bobBitmap,
                        50, 75, false)
        myCanvas.drawBitmap(bobBitmap, 250f, 25f, myPaint)
    }


}
