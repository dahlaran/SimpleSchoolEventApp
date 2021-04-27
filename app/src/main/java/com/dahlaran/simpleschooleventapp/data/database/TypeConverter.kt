package com.dahlaran.simpleschooleventapp.data.database

import androidx.room.TypeConverter
import com.dahlaran.simpleschooleventapp.models.Address
import com.dahlaran.simpleschooleventapp.models.Category
import com.dahlaran.simpleschooleventapp.models.Media
import com.dahlaran.simpleschooleventapp.models.Payload
import com.dahlaran.simpleschooleventapp.utils.fromJson
import com.dahlaran.simpleschooleventapp.utils.toJson
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject


class TypeConverter {
    @TypeConverter
    fun fromStringToAddress(value: String): Address {
        return value.let { Address.fromJson(JSONObject(it)) }
    }

    @TypeConverter
    fun fromAddressToString(address: Address): String {
        return address.toJson()
    }

    @TypeConverter
    fun fromStringToCategory(value: String): Category {
        return value.let { Category.fromJson(JSONObject(it)) }
    }

    @TypeConverter
    fun fromCategoryToString(category: Category): String {
        return category.toJson()
    }

    @TypeConverter
    fun fromStringToMedia(value: String): Media {
        return value.let { Media.fromJson(JSONObject(it)) }
    }

    @TypeConverter
    fun fromMediaToString(media: Media): String {
        return media.toJson()
    }

    @TypeConverter
    fun fromStringToPayload(value: String): Payload {
        return value.let { Payload.fromJson(JSONObject(it)) }
    }

    @TypeConverter
    fun fromPayloadToString(payload: Payload): String {
        return payload.toJson()
    }

    @TypeConverter
    fun fromStringToListString(value: String): List<String>{
        return ArrayList<String>().fromJson(JSONArray(value))
    }

    @TypeConverter
    fun fromListStringToString(list: List<String>): String{
        return list.toJson()
    }

    @TypeConverter
    fun fromStringToListCategory(value: String): List<Category>{
        return ArrayList<Category>().fromJson(JSONArray(value))
    }

    @TypeConverter
    fun fromListCategoryToString(list: List<Category>): String{
        return list.toJson()
    }

    @TypeConverter
    fun fromStringToListMedia(value: String): List<Media>{
        return ArrayList<Media>().fromJson(JSONArray(value))
    }

    @TypeConverter
    fun fromListMediaToString(list: List<Media>): String{
        return list.toJson()
    }
}