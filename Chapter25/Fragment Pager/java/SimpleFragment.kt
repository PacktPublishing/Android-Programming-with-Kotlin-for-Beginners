package com.gamecodeschool.fragmentslider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment

class SimpleFragment: Fragment() {
    // Our companion object which
    // we call to make a new Fragment
    companion object {
        // Holds the fragment id passed in when created
        val messageID = "messageID"

        fun newInstance(message: String)
                : SimpleFragment {
            // Create the fragment
            val fragment = SimpleFragment()

            // Create a bundle for our message/id
            val bundle = Bundle(1)
            // Load up the Bundle
            bundle.putString(messageID, message)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?)
            : View? {

        // Get the id from the Bundle
        val message = arguments!!.getString(messageID)

        // Inflate the view as normal
        val view = inflater.inflate(
                R.layout.fragment_layout,
                container,
                false)

        // Get a reference to textView
        val messageTextView = view.findViewById<View>(R.id.textView) as TextView

        // Display the id in the TextView
        messageTextView.text = message


        // We could also handle any UI
        // of any complexity in the usual way
        // And we will over the next two chapters
        // ..
        // ..

        return view
    }
}