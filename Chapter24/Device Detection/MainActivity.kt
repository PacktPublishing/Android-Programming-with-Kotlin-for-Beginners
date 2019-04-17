package com.gamecodeschool.devicedetectionemptyactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Point
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun detectDevice(v: View) {
        // What is the orientation?
        val display = windowManager.defaultDisplay
        txtOrientation.text = "${display.rotation}"

        // What is the resolution?
        val xy = Point()
        display.getSize(xy)
        txtResolution.text = "x = ${xy.x} y = ${xy.y}"
    }
}
