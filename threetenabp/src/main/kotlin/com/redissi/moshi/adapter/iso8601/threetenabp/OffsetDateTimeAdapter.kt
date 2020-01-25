package com.redissi.moshi.adapter.iso8601.threetenadp

import com.squareup.moshi.*
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class OffsetDateTimeAdapter {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")

    @ToJson fun toJson(offsetDateTime: OffsetDateTime?): String {
        if (offsetDateTime == null) {
            return "null"
        }
        return offsetDateTime.format(formatter)
    }

    @FromJson fun fromJson(offsetDateTime: String): OffsetDateTime? {
        if (offsetDateTime == "null") {
            return null
        }
        return OffsetDateTime.parse(offsetDateTime)
    }

}