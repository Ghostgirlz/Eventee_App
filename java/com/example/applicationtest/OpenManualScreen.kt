package com.example.applicationtest

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OpenManualScreen: AppCompatActivity() {
    @SuppressLint("SetTextI18n") // enables more advanced dictation and therefore the manual is easier to read
    // againg the 'onCreate' is overriden in order to show this as the screen appears
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manual_screen)

        // variable for the text
        val manual_text = findViewById<TextView>(R.id.manual_text)

        /* this changes the text to the manual text. It is done here for me to make it more readable
        and therefore I can be sure it is correct and exact.
         */
        manual_text.text =
                "How To Add an Event?\n" +
                "1. Click 'Create New Event'. \n" +
                "2. Enter all the needed data (in the neccesary format). \n" +
                "3. Click 'Confirm'. \n" +
                "4. A notification will appear if the event was added.\n\n" +
                "How to Delete an Event?\n" +
                "1. Click 'Create New Event.' \n" +
                "2. Enter data for 'name' and 'date' \n" +
                "3. Click 'Delete'.\n" +
                "4. A notification will appear if the event was deleted. \n\n" +
                "How to See Your Events? \n" +
                "1. Click 'View Calendar'. \n" +
                "2. Enter data to search by 'name' or 'date' or click buttons for specific priorities."
    }
}