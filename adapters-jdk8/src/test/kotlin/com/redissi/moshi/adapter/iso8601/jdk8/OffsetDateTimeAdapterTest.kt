package com.redissi.moshi.adapter.iso8601.threetenadp


import org.junit.Test

import org.junit.Assert.*
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeParseException

class OffsetDateTimeAdapterTest {

    private val adapter = OffsetDateTimeAdapter()

    @Test
    fun fromJson() {
        assertEquals(
            newDate(1970, 1, 1, 0, 0, 0, 0, 0),
            adapter.fromJson("1970-01-01T00:00:00.000Z")
        )
        assertEquals(
            newDate(1985, 4, 12, 23, 20, 50, 520 * 1000000, 0),
            adapter.fromJson("1985-04-12T23:20:50.520Z")
        )
        assertEquals(
            newDate(1996, 12, 19, 16, 39, 57, 0, -8),
            adapter.fromJson("1996-12-19T16:39:57-08:00")
        )
        assertThrows(
            DateTimeParseException::class.java
        ) { adapter.fromJson("1990-12-31T23:59:60Z") }
        assertEquals(
            newDate(1937, 1, 1, 12, 0, 27, 870 * 1000000, 0, 20),
            adapter.fromJson("1937-01-01T12:00:27.870+00:20")
        )

    }

    @Test
    fun toJson() {
        assertEquals(
            "1970-01-01T00:00:00.000Z",
            adapter.toJson(newDate(1970, 1, 1, 0, 0, 0, 0, 0))
        )
        assertEquals(
            "1985-04-12T23:20:50.520Z",
            adapter.toJson(newDate(1985, 4, 12, 23, 20, 50, 520 * 1000000, 0))
        )
        assertEquals(
            "1996-12-19T16:39:57.000-08:00",
            adapter.toJson(newDate(1996, 12, 19, 16, 39, 57, 0, -8))
        )
        assertEquals(
            "1937-01-01T12:00:27.870+00:20",
            adapter.toJson(newDate(1937, 1, 1, 12, 0, 27, 870 * 1000000, 0, 20))
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
        nano: Int,
        offsetHours: Int,
        offsetMinutes: Int = 0
    ): OffsetDateTime {
        val zoneOffset = ZoneOffset.ofHoursMinutes(offsetHours, offsetMinutes)
        return OffsetDateTime.of(year, month, day, hour, minute, second, nano, zoneOffset)

    }
}