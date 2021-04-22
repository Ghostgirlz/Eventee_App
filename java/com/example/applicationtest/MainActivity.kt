package com.example.applicationtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    /* Polymorphism is used to override a 'onCreate' function to my exact specification and purpose
    * this being having multiple buttons each leading to individual screens. This needs to be done
    * the moment the screen is created. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables for the buttons
        val eventbutton = findViewById<Button>(R.id.goToEventScreen)
        val calendarButton = findViewById<Button>(R.id.goToCalendar)
        val manualButton = findViewById<Button>(R.id.goToManualScreen)

        /* Each of the buttons has a separate clicker and each of them starts a different activity
        * in this case that being the opening of a new screen.*/
        eventbutton.setOnClickListener {
            startActivity(Intent(this, OpenEventScreen::class.java))
        }
        calendarButton.setOnClickListener {
            startActivity(Intent(this, OpenCalendarScreen::class.java))
        }
        manualButton.setOnClickListener {
            startActivity(Intent(this, OpenManualScreen::class.java))
        }
    }

}