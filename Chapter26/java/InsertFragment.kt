package com.gamecodeschool.agedatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

class InsertFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
                                : View? {

        // Database and UI code goes here in next chapter


        return inflater.inflate(R.layout.content_insert,
                container,
                false)
    }
}
