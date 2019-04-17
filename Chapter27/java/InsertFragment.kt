package com.gamecodeschool.agedatabasepart2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import android.widget.EditText



class InsertFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
                                : View? {

        val view = inflater.inflate(
                R.layout.content_insert,
                container,
                false)

        // Database and UI code goes here in next chapter
        val dm = DataManager(activity!!)

        val btnInsert = view.findViewById(R.id.btnInsert) as Button
        val editName = view.findViewById(R.id.editName) as EditText
        val editAge = view.findViewById(R.id.editAge) as EditText

        btnInsert.setOnClickListener({
            dm.insert(editName.text.toString(),
                    editAge.text.toString())
        })


        return view
    }
}
