package com.dahlaran.simpleschooleventapp.models

import com.dahlaran.simpleschooleventapp.utils.DateUtils

data class MonthEvent(val year: Int, val month: Int) {
    fun getEventMonthShow(): String{
        return DateUtils.getMonthString(month)
    }
}