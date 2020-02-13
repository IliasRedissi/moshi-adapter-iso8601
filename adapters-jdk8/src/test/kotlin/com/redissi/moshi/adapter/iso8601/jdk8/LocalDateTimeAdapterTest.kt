package com.redissi.moshi.adapter.iso8601.jdk8


import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime
import java.time.format.DateTimeParseException

class LocalDateTimeAdapterTest {

    private val adapter = LocalDateTimeAdapter()

    @Test
    fun fromJson() {
        assertEquals(
            newDate(1970, 1, 1, 0, 0, 0, 0),
            adapter.fromJson("1970-01-01T00:00:00.000")
        )
        assertEquals(
            newDate(1985, 4, 12, 23, 20, 50, 520 * 1000000),
            adapter.fromJson("1985-04-12T23:20:50.520")
        )
        assertEquals(
            newDate(1996, 12, 19, 16, 39, 57, 0),
            adapter.fromJson("1996-12-19T16:39:57")
        )
        assertThrows(
            DateTimeParseException::class.java
        ) { adapter.fromJson("1990-12-31T23:59:59Z") }
        assertEquals(
            newDate(1937, 1, 1, 12, 0, 27, 870 * 1000000),
            adapter.fromJson("1937-01-01T12:00:27.870")
        )

    }

    @Test
    fun toJson() {
        assertEquals(
            "1970-01-01T00:00:00.000",
            adapter.toJson(newDate(1970, 1, 1, 0, 0, 0, 0))
        )
        assertEquals(
            "1985-04-12T23:20:50.520",
            adapter.toJson(newDate(1985, 4, 12, 23, 20, 50, 520 * 1000000))
        )
        assertEquals(
            "1996-12-19T16:39:57.000",
            adapter.toJson(newDate(1996, 12, 19, 16, 39, 57, 0))
        )
        assertEquals(
            "1937-01-01T12:00:27.870",
            adapter.toJson(newDate(1937, 1, 1, 12, 0, 27, 870 * 1000000))
        )
    }

    @Test
    fun nullSafety() {
        assertEquals("null", adapter.toJson(null))
        assertEquals(null, adapter.fromJson("null"))
    }

    private fun newDate(
        year: Int,
        month: Int,
        day: Int,
        hour: Int,
        minute: Int,
        second: Int,
        nano: Int
    ): LocalDateTime {
        return LocalDateTime.of(year, month, day, hour, minute, second, nano)
    }
}