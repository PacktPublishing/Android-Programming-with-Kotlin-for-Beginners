package com.gamecodeschool.livedrawing


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.SurfaceView

// The LiveDrawingView constructor
// Called when this line:
// liveDrawingView = LiveDrawingView(this, size.x, size.y);
// is executed from MainActivity
class LiveDrawingView(
        context: Context,
        screenX: Int)
    : SurfaceView(context), Runnable {

    // Are we debugging?
    private val debugging = true

    // These objects are needed to do the drawing
    private lateinit var canvas: Canvas
    private val paint: Paint = Paint()

    // How many frames per second did we get?
    private var fps: Long = 0
    // The number of milliseconds in a second
    private val millisInSecond: Long = 1000

    // How big will the text be?
    // Font is 5% (1/20th) of screen width
    // Margin is 1.5% (1/75th) of screen width
    private val fontSize: Int = screenX / 20
    private val fontMargin: Int = screenX / 75

    // The particle systems will be declared here later

    // Here is the Thread and two control variables
    private lateinit var thread: Thread
    // This volatile variable can be accessed
    // from inside and outside the thread
    @Volatile
    private var drawing: Boolean = false
    private var paused = true


    // Draw the particle systems and the HUD
    private fun draw() {
        if (holder.surface.isValid) {
            // Lock the canvas (graphics memory) ready to draw
            canvas = holder.lockCanvas()

            // Fill the screen with a solid color
            canvas.drawColor(Color.argb(255, 0, 0, 0))

            // Choose a color to paint with
            paint.color = Color.argb(255, 255, 255, 255)

            // Choose the font size
            paint.textSize = fontSize.toFloat()

            // Draw the particle systems

            // Draw the HUD

            if (debugging) {
                printDebuggingText()
            }
            // Display the drawing on screen
            // unlockCanvasAndPost is a method of SurfaceHolder
            holder.unlockCanvasAndPost(canvas)
        }

    }

    // When we start the thread with:
    // thread.start();
    // the run function is continuously called by Android
    // because we implemented the Runnable interface
    // Calling mThread.join();
    // will stop the thread
    override fun run() {
        // The drawing Boolean  gives us finer control
        // rather than just relying on the calls to run
        // drawing must be true AND
        // the thread running for the main
        // loop to execute
        while (drawing) {

            // What time is it now at the start of the loop?
            val frameStartTime = System.currentTimeMillis()

            // Provided the app isn't paused
            // call the update method
            if (!paused) {
                update()
            }

            // The movement has been handled
            // we can draw the scene.
            draw()

            // How long did this frame/loop take?
            // Store the answer in timeThisFrame
            val timeThisFrame = System.currentTimeMillis() - frameStartTime

            // Make sure timeThisFrame is at least 1 millisecond
            // because accidentally dividing
            // by zero crashes the app
            if (timeThisFrame > 0) {
                // Store the current frame rate in fps
                // ready to pass to the update functions of
                // of our particles in the next frame/loop
                fps = millisInSecond / timeThisFrame
            }
        }
    }


    private fun update() {
        // Update the particles
    }


    private fun printDebuggingText() {
        val debugSize = fontSize / 2
        val debugStart = 150
        paint.textSize = debugSize.toFloat()
        canvas.drawText("fps: $fps",
                10f, (debugStart + debugSize).toFloat(), paint)

    }

    // This function is called by MainActivity
    // when the user quits the app
    fun pause() {
        // Set drawing to false
        // Stopping the thread isn't
        // always instant
        drawing = false
        try {
            // Stop the thread
            thread.join()
        } catch (e: InterruptedException) {
            Log.e("Error:", "joining thread")
        }

    }


    // This function is called by MainActivity
    // when the player starts the app
    fun resume() {
        drawing = true
        // Initialize the instance of Thread
        thread = Thread(this)

        // Start the thread
        thread.start()
    }


}
