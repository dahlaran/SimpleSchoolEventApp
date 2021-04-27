package com.dahlaran.simpleschooleventapp.models


import org.json.JSONObject
import org.junit.Assert
import org.junit.Test

class AddressTest {

    @Test
    fun fromJsonTest() {
        val json = "{\n" +
                "streetAddress: \"11 rue de Quetigny\",\n" +
                "zipCode: \"21560\",\n" +
                "cityName: \"Couternon\",\n" +
                "countryName: \"FRANCE\",\n" +
                "countryCode: \"FR\"\n" +
                "}"

        val address = Address(
            "Couternon",
            "FR",
            "FRANCE",
            "11 rue de Quetigny",
            "21560"
        )

        val testAddress: Address = Address.fromJson(JSONObject(json))

        Assert.assertEquals(address.cityName, testAddress.cityName)
        Assert.assertEquals(address.countryCode, testAddress.countryCode)
        Assert.assertEquals(address.countryName, testAddress.countryName)
        Assert.assertEquals(address.streetAddress, testAddress.streetAddress)
        Assert.assertEquals(address.zipCode, testAddress.zipCode)
    }

    @Test
    fun toJsonTest() {
        val json = "{\"cityName\":\"Couternon\"," +
                "\"countryCode\":\"FR\"," +
                "\"countryName\":\"FRANCE\"," +
                "\"streetAddress\":\"11 rue de Quetigny\"," +
                "\"zipCode\":\"21560\"}"

        val address = Address(
            "Couternon",
            "FR",
            "FRANCE",
            "11 rue de Quetigny",
            "21560"
        )

        val testJson: String = address.toJson()

        Assert.assertEquals(json.trim(), testJson.trim())
    }
}