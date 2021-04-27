package com.dahlaran.simpleschooleventapp.models

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

data class Address(
    val cityName: String,
    val countryCode: String,
    val countryName: String,
    val streetAddress: String,
    val zipCode: String
) {
    companion object {
        @Throws(JSONException::class)
        fun fromJson(json: JSONObject): Address {
            return Address(
                json.getString("cityName"),
                json.getString("countryCode"),
                json.getString("countryName"),
                json.getString("streetAddress"),
                json.getString("zipCode")
            )
        }
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}