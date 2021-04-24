package com.dahlaran.simpleschooleventapp.models

import android.text.Spanned
import com.dahlaran.simpleschooleventapp.utils.DateUtils
import com.dahlaran.simpleschooleventapp.utils.HtmlUtils
import java.util.*

data class Event(
    val address: Address,
    val appIds: String,
    val categories: List<Category>,
    val content: String,
    val createdAt: String,
    val createdBy: String,
    val dateEnd: String,
    val dateStart: String,
    val editor_access: Boolean,
    val form: String,
    val id: String,
    val linksToItem: List<Any>,
    val medias: List<Any>,
    val name: String,
    val owner: String,
    val parentsFixedAt: String,
    val payload: Payload,
    val payload_schema: String,
    val publishState: String,
    val slug: String,
    val title: String,
    val type: String,
    val updatedAt: String
) {
    private var contentSpanned: Spanned? = null
    private var eventDateStart: Date? = null

    fun generateEventDateText(): String {
        if (eventDateStart == null) {
            eventDateStart = DateUtils.getEventDateTime(dateStart)
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
}

