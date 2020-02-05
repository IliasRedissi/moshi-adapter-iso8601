package com.redissi.moshi.adapter.iso8601.threetenadp

import com.squareup.moshi.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeAdapter {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")

    @ToJson fun toJson(localDateTime: LocalDateTime?): String {
        if (localDateTime == null) {
            return "null"
        }
        return localDateTime.format(formatter)
    }

    @FromJson fun fromJson(localDateTime: String): LocalDateTime? {
        if (localDateTime == "null") {
            return null
        }
        return LocalDateTime.parse(localDateTime)
    }

}