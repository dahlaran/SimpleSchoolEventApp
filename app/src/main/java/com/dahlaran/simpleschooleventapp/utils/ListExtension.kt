package com.dahlaran.simpleschooleventapp.utils

import com.dahlaran.simpleschooleventapp.models.Category
import com.dahlaran.simpleschooleventapp.models.Media
import com.dahlaran.simpleschooleventapp.models.Payload
import com.google.gson.Gson
import org.json.JSONArray


fun <T> List<T>.toJson(): String {
    return Gson().toJson(this)
}

inline fun <reified T> List<T>.fromJson(jsonArray: JSONArray?): List<T> {
    val listdata = ArrayList<T>()
    val jArray = jsonArray
    if (jArray != null) {
        for (i in 0 until jArray.length()) {
            val type = when (T::class){
                String::class -> jArray.getString(i)
                Category::class -> Category.fromJson(jArray.getJSONObject(i))
                Media::class -> Media.fromJson(jArray.getJSONObject(i))
                Payload::class -> Payload.fromJson(jArray.getJSONObject(i))
                else -> {
                    // Warning: All type must be declare upper

                    jArray.getString(i)
                }
            }

            listdata.add(type as T)
        }
    }
    return listdata
}
