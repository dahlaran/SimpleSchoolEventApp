package com.dahlaran.simpleschooleventapp.models

import com.dahlaran.simpleschooleventapp.utils.DateUtils

data class MonthEvent(val eventList: List<Event>, val year: Int, val month: Int) {
    fun getEventMonthShow(): String{
        return DateUtils.getMonthString(month)
    }
}