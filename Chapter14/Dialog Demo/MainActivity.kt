package com.gamecodeschool.dialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        // We could have removed the previous line of code by
        // adding the ...synthetic.main.activity_main.* import

        button.setOnClickListener {
            val myDialog = MyDialog()
            myDialog.show(supportFragmentManager, "123")
            // This calls onCreateDialog
            // Don't worry about the strange looking 123
            // We will find out about this in chapter 18
        }
    }
}
