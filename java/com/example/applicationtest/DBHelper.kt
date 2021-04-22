package com.example.applicationtest

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


class DBHelper (var context: Context) :SQLiteOpenHelper(context, databaseName, null, 1) {

    // Declaring Variables - each of them has a 'const' to ensure the variable is not changed
    companion object {
        const val databaseName = "EventsDatabase.db"
        const val tableName = "Events"
        const val colName = "Name"
        const val colDate = "Date"
        const val colStartTime = "StartTime"
        const val colEndTime = "EndTime"
        const val colPriority = "Priority"
        const val colDescription = "Description"
    }
    /* creating the table - using the SQL syntax as a string to enter commands to create a new table
    inside the database 'EventsDatabase'.  */
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "create table " + tableName +" (\n" +
                colName + " varchar(50) NOT NULL, \n " +
                colDate + " varchar(15) NOT NULL, \n" +
                colStartTime + " varchar(10) NOT NULL, \n" +
                colEndTime + " varchar(10) NOT NULL, \n" +
                colPriority + " varchar(15) NOT NULL, \n" +
                colDescription + " varchar(1000000) NOT NULL);"
        db?.execSQL(createTable)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    /* function for inserting data - takes in the data from the class Event and puts it into the
    database. This functions abstracts the process. The user simply input the data needed, which are
    then saved into the event Class which is then used to write individual parameters into the database.
    The user just inputs what he wants and both a separate 'event' is created and also that very
    event is put into the database.
     */
    fun insertData (event: Event) {
        val DB = this.writableDatabase
        val CV = ContentValues()
        CV.put(colName, event.name)
        CV.put(colDate, event.date)
        CV.put(colStartTime, event.startTime)
        CV.put(colEndTime, event.endTime)
        CV.put(colPriority, event.priority)
        CV.put(colDescription, event.description)
        var result = DB.insert(tableName, null, CV)
        // if result is a negative number, the event failed to add, if not it notifies the user that everything is fine
        if (result == (-1).toLong()) {
            Toast.makeText(context, "Failed to Add Event", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Event Added", Toast.LENGTH_SHORT).show()
        }
    }

    /* function for deleting the data - user inputs the data needed 'name' and 'date' and the function
    searches for entries which match the user inputted data. */
    fun deleteData(name: String, date: String) {
        val DB = this.writableDatabase
        DB.delete(tableName, "Name = ? " + "AND" + " Date = ?", arrayOf(name, date))
    }

    /* function for reading the data - here 'mutable list' is used to have a complete list of all the events
    which are in the database. The 'mutable list' is used for easy reading and going through when the data
    needs to be printed out. */
    fun readData() : MutableList<Event> {
        var eventList : MutableList<Event> = ArrayList() // creation of mutable list
        var command = "select * from " + tableName // using SQL syntax
        var database = this.readableDatabase
        val result = database.rawQuery(command, null)
        if (result.moveToFirst()) {
            do {
                var event = Event(
                        result.getString(result.getColumnIndex(colName)),
                        result.getString(result.getColumnIndex(colDate)),
                        result.getString(result.getColumnIndex(colStartTime)),
                        result.getString(result.getColumnIndex(colEndTime)),
                        result.getString(result.getColumnIndex(colPriority)),
                        result.getString(result.getColumnIndex(colDescription))
                )
                eventList.add(event)

            } while (result.moveToNext()) // reads until there is data to read
        }
        result.close()
        return eventList // returns the entire list with all the data
    }
}
