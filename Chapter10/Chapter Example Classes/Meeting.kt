package com.gamecodeschool.basicclasses

// Perhaps the user of the class
// doesn't know the time as it
// is yet to be confirmed
class Meeting(val day: String, val person: String) {
    var time: String = "To be decided"
    // The user of the class can
    // supply the day, time and person
    // of a meeting
    constructor(day: String, person: String, time: String)
            :this(day, person){

        // "this" refers to the current instance
        this.time = time
        // time (the property) now equals time
        // that was passed in as a parameter
    }
}