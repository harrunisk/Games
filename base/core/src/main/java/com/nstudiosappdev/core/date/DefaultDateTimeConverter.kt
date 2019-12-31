package com.nstudiosappdev.core.date

import java.lang.Exception
import java.sql.Timestamp
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class DefaultDateTimeConverter : DateTimeConverter {

    override fun getFormattedDateFromTimestamp(timeStamp: Long, datePattern: String): String {

        val validTimeStamp = Timestamp(timeStamp * 1000)
        val date = Date(validTimeStamp.time)
        val englishLocale = Locale("en", "us")

        return try {
            val dateFormat = SimpleDateFormat(datePattern, englishLocale)
            dateFormat.format(date)
        } catch (e: Exception) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            val month = calendar.get(Calendar.MONTH)
            val monthName = DateFormatSymbols(englishLocale).shortMonths[month]
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            "$dayOfMonth. $monthName" // Default format, in case there is an issue applying the pattern.
        }
    }

    override fun getCurrentDateAsTimestamp(): Long = Date().time
}
