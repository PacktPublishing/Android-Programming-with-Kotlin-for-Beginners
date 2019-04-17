package com.gamecodeschool.motetoselfpart3

import org.json.JSONException
import org.json.JSONObject

class Note {
    var title: String? = null
    var description: String? = null
    var idea: Boolean = false
    var todo: Boolean = false
    var important: Boolean = false

    private val JSON_TITLE = "title"
    private val JSON_DESCRIPTION = "description"
    private val JSON_IDEA = "idea"
    private val JSON_TODO = "todo"
    private val JSON_IMPORTANT = "important"

    // Constructor
    // Only used when new is called with a JSONObject
    @Throws(JSONException::class)
    constructor(jo: JSONObject) {

        title = jo.getString(JSON_TITLE)
        description = jo.getString(JSON_DESCRIPTION)
        idea = jo.getBoolean(JSON_IDEA)
        todo = jo.getBoolean(JSON_TODO)
        important = jo.getBoolean(JSON_IMPORTANT)
    }

    // Now we must provide an empty default constructor
    // for when we create a Note as we provide a
    // specialized constructor that must be used.
    constructor() {

    }

    @Throws(JSONException::class)
    fun convertToJSON(): JSONObject {

        val jo = JSONObject()

        jo.put(JSON_TITLE, title)
        jo.put(JSON_DESCRIPTION, description)
        jo.put(JSON_IDEA, idea)
        jo.put(JSON_TODO, todo)
        jo.put(JSON_IMPORTANT, important)

        return jo
    }









}