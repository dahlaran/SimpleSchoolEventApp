package com.dahlaran.simpleschooleventapp.models

import org.json.JSONObject
import org.junit.Assert
import org.junit.Test

class MediaTest {

    @Test
    fun fromJsonTest() {
        val json = "{\n" +
                "id: \"561fb77d823db4ce024b6abe\",\n" +
                "url: \"https://res.cloudinary.com/nomadeducation/image/upload/v1453904015/vs9w6fry81f2rvozxrtd.jpg\",\n" +
                "type: \"media\"\n" +
                "}"

        val media = Media(
            "561fb77d823db4ce024b6abe",
            "media",
            "https://res.cloudinary.com/nomadeducation/image/upload/v1453904015/vs9w6fry81f2rvozxrtd.jpg"
        )

        val testMedia: Media = Media.fromJson(JSONObject(json))

        Assert.assertEquals(media.id, testMedia.id)
        Assert.assertEquals(media.type, testMedia.type)
        Assert.assertEquals(media.url, testMedia.url)
    }

    @Test
    fun toJsonTest() {
        val json = "{" +
                "\"id\":\"561fb77d823db4ce024b6abe\"," +
                "\"type\":\"media\"," +
                "\"url\":\"https://res.cloudinary.com/nomadeducation/image/upload/v1453904015/vs9w6fry81f2rvozxrtd.jpg\"" +
                "}"

        val media = Media(
            "561fb77d823db4ce024b6abe",
            "media",
            "https://res.cloudinary.com/nomadeducation/image/upload/v1453904015/vs9w6fry81f2rvozxrtd.jpg"
        )

        val testJson: String = media.toJson()

        Assert.assertEquals(json.trim(), testJson.trim())
    }
}