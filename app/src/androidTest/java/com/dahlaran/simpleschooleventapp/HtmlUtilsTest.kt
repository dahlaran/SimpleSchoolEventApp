package com.dahlaran.simpleschooleventapp

import com.dahlaran.simpleschooleventapp.utils.HtmlUtils
import org.junit.Assert
import org.junit.Test

class HtmlUtilsTest {
    @Test
    fun convertHtmlTextToShowTextBasic() {
        val textString = "19QdD"

        Assert.assertEquals(textString, HtmlUtils.convertHtmlTextToShowText(textString).toString())
    }

    @Test
    fun convertHtmlTextToShowTextSimple() {
        val textString = "<p>19QdD</p>"

        Assert.assertEquals("19QdD", HtmlUtils.convertHtmlTextToShowText(textString).toString().trim())
    }
}