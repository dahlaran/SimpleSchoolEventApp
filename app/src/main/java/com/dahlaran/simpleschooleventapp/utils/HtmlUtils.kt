package com.dahlaran.simpleschooleventapp.utils

import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned

object HtmlUtils {

    /**
     * Return displayable styled text using html text
     */
    fun convertHtmlTextToShowText(htmlText: String?): Spanned {
        if (htmlText.isNullOrEmpty()) {
            return Html.fromHtml("")
        }
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml(htmlText, FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(htmlText)
        }
    }
}