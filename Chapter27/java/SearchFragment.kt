package com.gamecodeschool.agedatabasepart2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.EditText



class SearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
                                : View? {

        val view = inflater.inflate(R.layout.content_search,
                container,
                false)

        // Database and UI code goes here in next chapter
        val btnSearch = view.findViewById(R.id.btnSearch) as Button
        val editSearch = view.findViewById(R.id.editSearch) as EditText
        val textResult = view.findViewById(R.id.textResult) as TextView

        // This is our DataManager instance
        val dm = DataManager(activity!!)

        btnSearch.setOnClickListener(
                {
                    val c = dm.searchName(editSearch.text.toString())

            // Make sure a result was found before using the Cursor
            if (c.count > 0) {
                c.moveToNext()
                textResult.text =
                        "Result = ${c.getString(1)} - ${c.getString(2)}"
            }
        })

        return view
    }
}
