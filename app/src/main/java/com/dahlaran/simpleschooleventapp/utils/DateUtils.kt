package com.dahlaran.simpleschooleventapp.utils

import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object DateUtils {
    private val eventDateTimeFormatter: SimpleDateFormat by lazy {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    }

    fun getEventDateTime(airstamp: String?): Date? {
        if (airstamp == null) {
            return null
        }
        return try {
            eventDateTimeFormatter.parse(airstamp)
        } catch (e: ParseException) {
            null
        }
    }

    fun getYearFromDate(date: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.YEAR]
    }

    fun getMonthFromDate(date: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.MONTH] + 1
    }

    fun getDayOfWeekFromDate(date: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar[Calendar.DAY_OF_MONTH]
    }

    fun getStringToShowFromDate(date: Date?): String {
        return date?.let {
            String.format("%02d", DateUtils.getDayOfWeekFromDate(it)) + "/" +
                    String.format("%02d", DateUtils.getMonthFromDate(it))
        } ?: ""
    }

    fun getMonthString(month: Int): String {
        return DateFormatSymbols().getMonths().get(month - 1)
    }
}