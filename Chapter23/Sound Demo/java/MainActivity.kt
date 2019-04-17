package com.gamecodeschool.sounddemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import com.gamecodeschool.sounddemo.R.id.fab
import com.gamecodeschool.sounddemo.R.id.toolbar

import java.io.IOException;

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var sp: SoundPool? = null

    init{}

    var idFX1 = -1
    var idFX2 = -1
    var idFX3 = -1
    var nowPlaying = -1

    var volume = .1f
    var repeats = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val buttonFX1 = findViewById<View>(R.id.btnFX1) as Button
        buttonFX1.setOnClickListener(this)

        val buttonFX2 = findViewById<View>(R.id.btnFX2) as Button
        buttonFX2.setOnClickListener(this)

        val buttonFX3 = findViewById<View>(R.id.btnFX3) as Button
        buttonFX3.setOnClickListener(this)

        val buttonStop = findViewById<View>(R.id.btnStop) as Button
        buttonStop.setOnClickListener(this)


        // Instantiate our sound pool dependent upon which version of Android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build()

            sp = SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build()
        } else {
            sp = SoundPool(5, AudioManager.STREAM_MUSIC, 0)
        }

        try {
            // Create objects of the 2 required classes
            val assetManager = this.assets
            var descriptor: AssetFileDescriptor

            // Load our fx in memory ready for use
            descriptor = assetManager.openFd("fx1.ogg")
            idFX1 = sp.load(descriptor, 0)

            descriptor = assetManager.openFd("fx2.ogg")
            idFX2 = sp.load(descriptor, 0)

            descriptor = assetManager.openFd("fx3.ogg")
            idFX3 = sp.load(descriptor, 0)


        } catch (e: IOException) {
            // Print an error message to the console
            Log.e("error", "failed to load sound files")
        }

        // Now setup the seekbar
        val seekBar = findViewById<View>(R.id.seekBar) as SeekBar


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, value: Int, fromUser: Boolean) {
                volume = value / 10f
                sp.setVolume(nowPlaying, volume, volume)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        // Now for the spinner
        val spinner = findViewById<View>(R.id.spinner) as Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                val temp = spinner.selectedItem.toString()
                repeats = Integer.valueOf(temp)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {

            }

        }


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
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.btnFX1 -> {
                sp.stop(nowPlaying)
                nowPlaying = sp.play(idFX1, volume,
                        volume, 0, repeats, 1f)
            }

            R.id.btnFX2 -> {
                sp.stop(nowPlaying)
                nowPlaying = sp.play(idFX2,
                        volume, volume, 0, repeats, 1f)
            }

            R.id.btnFX3 -> {
                sp.stop(nowPlaying)
                nowPlaying = sp.play(idFX3,
                        volume, volume, 0, repeats, 1f)
            }

            R.id.btnStop -> sp.stop(nowPlaying)
        }


    }
}
