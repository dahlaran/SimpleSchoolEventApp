package com.dahlaran.simpleschooleventapp.models

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

class Payload(
){
    companion object {
        @Throws(JSONException::class)
        fun fromJson(json: JSONObject): Payload {
            return Payload(
            )
        }
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}