package com.redissi.moshi.adapter.iso8601.jdk8

import com.squareup.moshi.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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