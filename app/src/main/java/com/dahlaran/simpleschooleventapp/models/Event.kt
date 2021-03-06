package com.dahlaran.simpleschooleventapp.models

import android.text.Spanned
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.dahlaran.simpleschooleventapp.utils.DateUtils
import com.dahlaran.simpleschooleventapp.utils.HtmlUtils
import java.util.*

@Entity(tableName = "event_table")
data class Event(
    val address: Address,
    val categories: List<Category>,
    val content: String,
    val dateEnd: String,
    val dateStart: String,
    @PrimaryKey val id: String,
    val medias: List<Media>,
    val title: String,
) {
    @Ignore private var contentSpanned: Spanned? = null
    @Ignore var eventDateStart: Date? = null

    fun generateEventDateText(): String {
        if (eventDateStart == null) {
            generateDate()
        }

        return DateUtils.getStringToShowFromDate(eventDateStart)
    }

    fun generateTextContent(): String {
        if (contentSpanned == null) {
            contentSpanned = HtmlUtils.convertHtmlTextToShowText(content)
        }

        if (contentSpanned?.isNotEmpty() == true) {
            return contentSpanned.toString().trim()
        }
        return ""
    }

    fun generateDate(){
        eventDateStart = DateUtils.getEventDateTime(dateStart)
    }

    fun getEventYear(): Int {
        return eventDateStart?.let {
            DateUtils.getYearFromDate(it)
        } ?: run {
            generateEventDateText()
            if (eventDateStart != null) {
                getEventYear()
            } else {
                0
            }
        }
    }

    fun getEventMonth(): Int {
        return eventDateStart?.let {
            DateUtils.getMonthFromDate(it)
        } ?: run {
            generateEventDateText()
            if (eventDateStart != null) {
                getEventMonth()
            } else {
                0
            }
        }
    }
}

