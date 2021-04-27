package com.dahlaran.simpleschooleventapp.models

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

data class Media(
    val id: String,
    val type: String,
    val url: String
) {
    companion object {
        @Throws(JSONException::class)
        fun fromJson(json: JSONObject): Media {
            return Media(
                json.getString("id"),
                json.getString("type"),
                json.getString("url")
            )
        }
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}