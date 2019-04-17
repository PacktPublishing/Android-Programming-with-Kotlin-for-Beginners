package com.gamecodeschool.motetoselfpart3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*




class SettingsActivity : AppCompatActivity() {

    private var showDividers: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val prefs =
                getSharedPreferences(
                        "Note to self",
                        Context.MODE_PRIVATE)

        showDividers  = prefs.getBoolean("dividers", true)

        // Set the switch on or off as appropriate
        switch1.isChecked = showDividers



        switch1.setOnCheckedChangeListener {
            buttonView, isChecked ->

            showDividers = isChecked
        }


    }

    override fun onPause() {
        super.onPause()

        // Save the settings here
        val prefs =
                getSharedPreferences(
                        "Note to self",
                        Context.MODE_PRIVATE)

        val editor = prefs.edit()

        editor.putBoolean(
                "dividers", showDividers)

        editor.apply()
    }

}
