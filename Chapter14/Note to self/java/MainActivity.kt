package com.gamecodeschool.notetoself

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Temporary code
    private var tempNote = Note()

    var note1 = Note()
    var note2 = Note()
    var note3 = Note()
    // 96 more lines like the above
    var note100 = Note()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val dialog = DialogNewNote()
            dialog.show(supportFragmentManager, "")
        }

        // Temporary code
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            // Create a new DialogShowNote called dialog
            val dialog = DialogShowNote()

            // Send the note via the sendNoteSelected method
            dialog.sendNoteSelected(tempNote)

            // Create the dialog
            dialog.show(supportFragmentManager, "123")
        }

    }

    fun createNewNote(n: Note) {
        // Temporary code
        tempNote = n
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
