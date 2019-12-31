package com.nstudiosappdev.core.date

interface DateTimeConverter {

    fun getFormattedDateFromTimestamp(timeStamp: Long, datePattern: String): String

    fun getCurrentDateAsTimestamp(): Long
}
