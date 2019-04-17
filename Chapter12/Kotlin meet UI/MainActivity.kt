package com.gamecodeschool.kotlinmeetui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    // An int variable to hold a value
    private var value = 0


    override fun onClick(v: View) {
        // A local variable to use later
        val size: Float

        when (v.id) {
            R.id.btnAdd -> {
                value++
                txtValue.text = "$value"
            }

            R.id.btnTake -> {
                value--
                txtValue.text = "$value"
            }

            R.id.btnReset -> {
                value = 0
                txtValue.text = "$value"
            }

            R.id.btnGrow -> {
                size = txtValue.textScaleX
                txtValue.textScaleX = size + 1
            }

            R.id.btnShrink -> {
                size = txtValue.textScaleX
                txtValue.textScaleX = size - 1
            }

            R.id.btnHide -> if (txtValue.visibility == View.VISIBLE) {
                // Currently visible so hide it
                txtValue.visibility = View.INVISIBLE

                // Change text on the button
                btnHide.text = "SHOW"

            } else {
                // Currently hidden so show it
                txtValue.visibility = View.VISIBLE

                // Change text on the button
                btnHide.text = "HIDE"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Listen for all the button clicks
        btnAdd.setOnClickListener(this)
        btnTake.setOnClickListener(this)
        txtValue.setOnClickListener(this)
        btnGrow.setOnClickListener(this)
        btnShrink.setOnClickListener(this)
        btnReset.setOnClickListener(this)
        btnHide.setOnClickListener(this)

    }
}
