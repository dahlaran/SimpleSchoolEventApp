package com.dahlaran.simpleschooleventapp.models

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

data class Category(
    val id: String,
    val type: String
) {
    companion object {
        @Throws(JSONException::class)
        fun fromJson(json: JSONObject): Category {
            return Category(
                json.getString("id"),
                json.getString("type")
            )
        }
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}