package com.gamecodeschool.agedatabasepart2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import android.widget.EditText



class DeleteFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState:
                              Bundle?)
                                : View? {

        val view = inflater.inflate(
                R.layout.content_delete,
                container,
                false)

        // Database and UI code goes here in next chapter
        val dm = DataManager(activity!!)

        val btnDelete = view.findViewById(R.id.btnDelete) as Button
        val editDelete = view.findViewById(R.id.editDelete) as EditText

        btnDelete.setOnClickListener(
                {
                    dm.delete(editDelete.text.toString())
                }
        )

        return view
    }
}
