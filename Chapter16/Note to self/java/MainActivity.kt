package com.gamecodeschool.notetoselfpart2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DefaultItemAnimator





class MainActivity : AppCompatActivity() {

    // Temporary code
    //private var tempNote = Note()

    private val noteList = ArrayList<Note>()
    private var recyclerView: RecyclerView? = null
    private var adapter: NoteAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val dialog = DialogNewNote()
            dialog.show(supportFragmentManager, "")
        }

        recyclerView =
                findViewById<View>(R.id.recyclerView) as RecyclerView

        adapter = NoteAdapter(this, noteList)
        val layoutManager = LinearLayoutManager(applicationContext)

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()

        // Add a neat dividing line between items in the list
        recyclerView!!.addItemDecoration(
                DividerItemDecoration(this,
                        LinearLayoutManager.VERTICAL))

        // set the adapter
        recyclerView!!.adapter = adapter
    }

    fun createNewNote(n: Note) {
        // Temporary code
        // tempNote = n
        noteList.add(n)
        adapter!!.notifyDataSetChanged()

    }

    fun showNote(noteToShow: Int) {
        val dialog = DialogShowNote()
        dialog.sendNoteSelected(noteList[noteToShow])
        dialog.show(supportFragmentManager, "")
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
