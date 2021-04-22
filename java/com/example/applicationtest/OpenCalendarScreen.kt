package com.example.applicationtest

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class OpenCalendarScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendar_screen)

        // Buttons for priorities - usage of variables to simply the process
        val red_priority_button = findViewById<Button>(R.id.redPriorityButton)
        val orange_priority_button = findViewById<Button>(R.id.orangePriorityButton)
        val yellow_priority_button = findViewById<Button>(R.id.yellowPriorityButton)

        //Buttons of Date and Name Specification - usage of variable to simplyfy the process
        val search_by_name_button = findViewById<Button>(R.id.searchByNameButton)
        val search_by_date_button = findViewById<Button>(R.id.searchByDateButton)

        // User input - using varibales since there will be multiple instances in the code
        val searchEventName = findViewById<EditText>(R.id.eventNameSpec)
        val searchDateName = findViewById<EditText>(R.id.eventDateSpec)

        // Database (Textfield and variable for the database)
        val event_test = findViewById<TextView>(R.id.event_test)
        var database = DBHelper(this)


        /* Button Functionality - the functions set a click listener to the button (based on the priorities), if clicked
        * the function searches the database for the specific parameters and prints only the ones that fulfill them. The data is added
        * to the 'event_test' TextView and then it's all printed at once.*/
        red_priority_button.setOnClickListener {
            val data = database.readData()
            event_test.text = ""
            for (i in 0 until data.size) {
                if (data.get(i).priority.decapitalize() == "red") {
                    event_test.append("\n Event name: " + data.get(i).name + " | Date: " + data.get(i).date + "\n" +
                            " | Starts at: " + data.get(i).startTime + " | Ends at: " + data.get(i).endTime + "\n" +
                            " | Description: " + data.get(i).description + "\n \n")
                } else {

                }
            }
        }
        orange_priority_button.setOnClickListener {
            val data = database.readData()
            event_test.text = ""
            for (i in 0 until data.size) {
                if (data.get(i).priority.decapitalize() == "orange") {
                    event_test.append("\n Event name: " + data.get(i).name + " | Date: " + data.get(i).date + "\n" +
                            " | Starts at: " + data.get(i).startTime + " | Ends at: " + data.get(i).endTime + "\n" +
                            " | Description: " + data.get(i).description + "\n \n")
                } else {

                }
            }
        }
        yellow_priority_button.setOnClickListener {
            val data = database.readData()
            event_test.text = ""
            for (i in 0 until data.size) {
                if (data.get(i).priority.decapitalize() == "yellow") {
                    event_test.append("\n Event name: " + data.get(i).name + " | Date: " + data.get(i).date + "\n" +
                            " | Starts at: " + data.get(i).startTime + " | Ends at: " + data.get(i).endTime + "\n" +
                            " | Description: " + data.get(i).description + "\n \n")
                } else {

                }

            }
        }
        /* Similar as for buttons but these take in the input of the user (the input is encapsulated to prevent bugs)
        * and use the input and compare it to the database, printing out only the entries which include it. */
        search_by_name_button.setOnClickListener{
            val name = searchEventName.text.toString()
            val data = database.readData()
            event_test.text = ""
            for (i in 0 until data.size) {
                if (data.get(i).name == name) {
                    event_test.append("\n Event name: " + data.get(i).name + " | Date: " + data.get(i).date + "\n" +
                            " | Starts at: " + data.get(i).startTime + " | Ends at: " + data.get(i).endTime + "\n" +
                            " | Description: " + data.get(i).description + "\n \n")
                } else {

                }
            }
        }
        search_by_date_button.setOnClickListener {
            val date = searchDateName.text.toString()
            val data = database.readData()
            event_test.text = ""
            for (i in 0 until data.size) {
                if (data.get(i).date == date) {
                    event_test.append("\n Event name: " + data.get(i).name + " | Date: " + data.get(i).date + "\n" +
                            " | Starts at: " + data.get(i).startTime + " | Ends at: " + data.get(i).endTime + "\n" +
                            " | Description: " + data.get(i).description + "\n \n")
                } else {

                }
            }
        }
    }
}