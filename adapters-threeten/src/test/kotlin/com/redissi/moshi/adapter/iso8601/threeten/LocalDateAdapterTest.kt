package com.redissi.moshi.adapter.iso8601.threeten


import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeParseException

class LocalDateAdapterTest {

    private val adapter = LocalDateAdapter()

    @Test
    fun fromJson() {
        assertEquals(
            newDate(1970, 1, 1),
            adapter.fromJson("1970-01-01")
        )
        assertEquals(
            newDate(1985, 4, 12),
            adapter.fromJson("1985-04-12")
        )
        assertEquals(
            newDate(1996, 12, 19),
            adapter.fromJson("1996-12-19")
        )
        assertThrows(
            DateTimeParseException::class.java
        ) { adapter.fromJson("1990-12-32") }
        assertEquals(
            newDate(1937, 1, 1),
            adapter.fromJson("1937-01-01")
        )

    }

    @Test
    fun toJson() {
        assertEquals(
            "1970-01-01",
            adapter.toJson(newDate(1970, 1, 1))
        )
        assertEquals(
            "1985-04-12",
            adapter.toJson(newDate(1985, 4, 12))
        )
        assertEquals(
            "1996-12-19",
            adapter.toJson(newDate(1996, 12, 19))
        )
        assertEquals(
            "1937-01-01",
            adapter.toJson(newDate(1937, 1, 1))
        )
    }

    @Test
    fun nullSafety() {
        assertEquals("null", adapter.toJson(null))
        assertEquals(null, adapter.fromJson("null"))
    }

    private fun newDate(year: Int, month: Int, day: Int): LocalDate {
        return LocalDate.of(year, month, day)
    }
}