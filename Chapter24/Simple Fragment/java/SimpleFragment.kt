package com.gamecodeschool.simplefragment

import androidx.fragment.app.Fragment
import android.widget.Toast
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Button


class SimpleFragment: Fragment() {
    val myString: String = "Hello from SimpleFragment"



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
                                : View? {

        val view = inflater.inflate(
                R.layout.fragment_layout,
                container,
                false)


        val button = view.findViewById(R.id.button) as Button

        button.setOnClickListener(
                {
                    Toast.makeText(activity,
                            myString, Toast.LENGTH_SHORT).show()
                }
        )

        return view
    }
}