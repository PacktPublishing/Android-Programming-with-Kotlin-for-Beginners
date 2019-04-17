package com.gamecodeschool.livedrawingpart2

import android.app.Activity
import android.os.Bundle
import android.graphics.Point

class MainActivity : Activity() {

    private lateinit var liveDrawingView: LiveDrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        liveDrawingView = LiveDrawingView(
                this, size.x)
        setContentView(liveDrawingView)

    }

    override fun onResume() {
        super.onResume()

        // More code here later in the chapter
        liveDrawingView.resume()
    }

    override fun onPause() {
        super.onPause()

        // More code here later in the chapter
        liveDrawingView.pause()
    }
}
