package com.gamecodeschool.dialogdemo

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class MyDialog : DialogFragment() {

    override
    fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // Use the Builder class because this dialog
        // has a simple UI.
        // We will use the more flexible onCreateView function
        // instead of onCreateDialog in the next project
        val builder = AlertDialog.Builder(activity!!)

        // Dialog will have "Make a selection" as the title
        builder.setMessage("Make a selection")
                // An OK button that does nothing
                .setPositiveButton("OK", { dialog, id ->
                    // Nothing happening here
                })
                // A "Cancel" button that does nothing
                .setNegativeButton("Cancel", { dialog, id ->
                    // Nothing happening here either
                })

        // Create the object and return it
        return builder.create()
    }// End of onCreateDialog

}