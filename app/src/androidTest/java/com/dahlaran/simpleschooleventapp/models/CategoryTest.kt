package com.dahlaran.simpleschooleventapp.models

import org.json.JSONObject
import org.junit.Assert
import org.junit.Test

class CategoryTest {

    @Test
    fun fromJsonTest() {
        val json = "{\n" +
                "id: \"56601413a3e361443919aedb\",\n" +
                "type: \"category\"\n" +
                "}"

        val category = Category(
            "56601413a3e361443919aedb",
            "category"
        )

        val testCategory: Category = Category.fromJson(JSONObject(json))

        Assert.assertEquals(category.id, testCategory.id)
        Assert.assertEquals(category.type, testCategory.type)
    }

    @Test
    fun toJsonTest() {
        val json = "{\"id\":\"56601413a3e361443919aedb\",\"type\":\"category\"}"

        val category = Category(
            "56601413a3e361443919aedb",
            "category"
        )

        val testJson: String = category.toJson()

        Assert.assertEquals(json.trim(), testJson.trim())
    }
}