package com.redissi.moshi.adapter.iso8601.threeten

import com.squareup.moshi.*
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class LocalDateAdapter {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    @ToJson fun toJson(localDate: LocalDate?): String {
        if (localDate == null) {
            return "null"
        }
        return localDate.format(formatter)
    }

    @FromJson fun fromJson(localDate: String): LocalDate? {
        if (localDate == "null") {
            return null
        }
        return LocalDate.parse(localDate)
    }

}