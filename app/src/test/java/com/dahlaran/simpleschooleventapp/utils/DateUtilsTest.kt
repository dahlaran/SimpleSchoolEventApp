package com.dahlaran.simpleschooleventapp.utils

import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateUtilsTest {
    @Test
    fun generateDateTime() {
        val dateString = "2019-07-26T12:00:00+00:00"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

        Assert.assertEquals(dateFormat.parse(dateString), DateUtils.getEventDateTime(dateString))
    }

    @Test
    fun generateDateEmpty() {
        val dateString = ""

        Assert.assertEquals(null, DateUtils.getEventDateTime(dateString))
    }

    @Test
    fun generateDateIncorrect() {
        val dateString = "24TSdqwqg-21"

        Assert.assertEquals(null, DateUtils.getEventDateTime(dateString))
    }

    @Test
    fun generateDateCheckNullable() {
        val dateString = null

        Assert.assertEquals(null, DateUtils.getEventDateTime(dateString))
    }

    @Test
    fun getYearFromDateCheck() {
        val dateString = "2021-04-24T12:00:00+00:00"
        val date: Date? = DateUtils.getEventDateTime(dateString)

        assert(date != null)
        Assert.assertEquals(2021, DateUtils.getYearFromDate(date!!))
    }

    @Test
    fun getMonthFromDateCheck() {
        val dateString = "2021-04-24T12:00:00+00:00"
        val date: Date? = DateUtils.getEventDateTime(dateString)

        assert(date != null)
        Assert.assertEquals(4, DateUtils.getMonthFromDate(date!!))
    }

    @Test
    fun getDayFromDateCheck() {
        val dateString = "2021-04-24T12:00:00+00:00"
        val date: Date? = DateUtils.getEventDateTime(dateString)

        assert(date != null)
        Assert.assertEquals(24, DateUtils.getDayOfWeekFromDate(date!!))
    }

    @Test
    fun getStringToShowFromDateCheck() {
        val dateString = "2021-04-24T12:00:00+00:00"
        val date: Date? = DateUtils.getEventDateTime(dateString)

        Assert.assertEquals("24/04", DateUtils.getStringToShowFromDate(date))
    }
}