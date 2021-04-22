package com.example.applicationtest

// a class create specifically to act as a middleman when transfering data. It makes the code more simple.
data class Event (
    var name: String,
    var date: String,
    var startTime: String,
    var endTime: String,
    var priority: String,
    var description: String

)