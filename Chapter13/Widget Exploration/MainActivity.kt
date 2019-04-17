package com.gamecodeschool.widgetexploration

import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.exploration_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exploration_layout)


        // Listen for clicks on the button,
        // the CheckBoxes and the RadioButtons

        // setOnCheckedChangedListener requires an interface of type
        // CompoundButton.OnCheckedChangeListener. In turn this interface
        // has a function called onCheckedChanged
        checkBoxTransparency.setOnCheckedChangeListener({
            view, isChecked ->
                if (isChecked) {
                    // Set some transparency
                    imageView.alpha = .1f
                } else {
                    // Remove the transparency
                    imageView.alpha = 1f
                }
        })

        // First the check boxes using an anonymous class
        checkBoxTint.setOnCheckedChangeListener({
            view, isChecked ->
            if (isChecked) {
                // Checked so set some tint
                imageView.setColorFilter(Color.argb(150, 255, 0, 0))
            } else {
                // No tint required
                imageView.setColorFilter(Color.argb(0, 0, 0, 0))
            }
        })

        // First the check boxes using an anonymous class
        checkBoxReSize.setOnCheckedChangeListener({
            view, isChecked ->
            if (isChecked) {
                // It's checked so make bigger
                imageView.scaleX = 2f
                imageView.scaleY = 2f
            } else {
                // It's not checked make regular size
                imageView.scaleX = 1f
                imageView.scaleY = 1f
            }
        })


        // Now for the radio buttons
        // Uncheck all buttons
        radioGroup.clearCheck()

        radioGroup.setOnCheckedChangeListener {
            group, checkedId ->
            val rb = group.findViewById<View>(checkedId) as RadioButton

            when (rb.id) {
                R.id.radioButtonLondon ->
                    textClock.timeZone = "Europe/London"

                R.id.radioButtonBeijing ->
                    textClock.timeZone = "CST6CDT"


                R.id.radioButtonNewYork ->
                    textClock.timeZone = "America/New_York"


                R.id.radioButtonEuropeanEmpire ->
                    textClock.timeZone = "Europe/Brussels"
            }
        }

        /*
           Let's listen for clicks on our "Capture" Button.
           The compiler has worked out that the single function
           of the required interface has a single parameter.
           Therefore the syntax is shortened (->) is removed
           and the only parameter is declared invisibly as "it"
        */
        button.setOnClickListener {
            // it... accesses the view that was clicked

            // We want to act on the textView and editText instances
            // Change the text on the TextView
            // to whatever is currently in the EditText
            textView.text = editText.text
        }


        // Show or hide the TextView
        switch1.setOnCheckedChangeListener {
            buttonView, isChecked ->
            if (isChecked) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.INVISIBLE
            }
        }
    }
}