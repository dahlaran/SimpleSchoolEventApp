package com.dahlaran.simpleschooleventapp.models

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MonthEventTest {

    lateinit var monthEvent: MonthEvent

    @Before
    fun before(){
        monthEvent = MonthEvent(2012, 12)
    }

    @Test
    fun getEventMonthShowTest(){
        Assert.assertEquals("December", monthEvent.getEventMonthShow())
    }
}