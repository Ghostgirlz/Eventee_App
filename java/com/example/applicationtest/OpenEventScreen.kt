package com.example.applicationtest

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OpenEventScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_event_screen)

        // Obtaining values from edittext to use in the database when deleting or editing data
        val eventName = findViewById<EditText>(R.id.eventNameString)
        val eventDate = findViewById<EditText>(R.id.eventDateNumber)
        val eventStartTime = findViewById<EditText>(R.id.eventStartTime)
        val eventEndTime = findViewById<EditText>(R.id.eventEndTime)
        val eventPriority = findViewById<EditText>(R.id.eventPriorityString)
        val eventDescription = findViewById<EditText>(R.id.eventDescriptionString)
        val confirmEventButton = findViewById<Button>(R.id.confirmEventButton)
        val deleteEventButton = findViewById<Button>(R.id.deleteEventButton)

        /* Confirm button listener - continuation of the abstraction fo the data insertion. Here
        the individual data are added to their respective categories and then the entire 'event' is created
        which is then used to be added to database */
        confirmEventButton.setOnClickListener{

            // making String Variables
            val nameString = eventName.text.toString()
            val dateString = eventDate.text.toString()
            val startTimeString = eventStartTime.text.toString()
            val endTimeString = eventEndTime.text.toString()
            val priorityString = eventPriority.text.toString()
            val descriptionString = eventDescription.text.toString()

            // Check if everything was filled out
            if (nameString.isNotEmpty() && dateString.isNotEmpty() && startTimeString.isNotEmpty() && endTimeString.isNotEmpty() && descriptionString.isNotEmpty()) {
                var newEvent = Event(nameString, dateString, startTimeString, endTimeString,priorityString ,descriptionString)
                var database = DBHelper(this)
                database.insertData(newEvent)
            } else {
                Toast.makeText(this, "Please Enter All Data!", Toast.LENGTH_SHORT).show() // if not it notifies the user
            }

        }

        //Delete Button Listener - 'name' and 'date' input are converted into a string to compare to the entries
        deleteEventButton.setOnClickListener {
            val nameString = eventName.text.toString()
            val dateString = eventDate.text.toString()

            if (nameString.isNotEmpty() && dateString.isNotEmpty()) {
                val database = DBHelper(this)
                database.deleteData(nameString, dateString)
                // used to notify the user if it was succesful
                Toast.makeText(this, "Event Deleted.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Enter All Data!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}