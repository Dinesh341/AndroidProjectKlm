package com.my.klm

import com.my.klm.utils.PrefUtils
import org.junit.Test

import org.junit.Assert.*

class FlighDetailsValidatorTest {

    private var validFlightNuber: String = "KL1234"
    private var invalidFlightNuber: String = "KL34"
    private var invalidDateString: String = "Select Date"
    private var invalidEndDateString: String = "End Date"
    private var invalidFromDateString: String = "Start Date"
    private var validDate: String = "2019-08-23"

    @Test
    fun checkFlightNumber() {
        assertEquals(true, PrefUtils.validateFlightNumber(validFlightNuber))
    }

    @Test
    fun checkInvalidFlightNumber() {
        assertEquals(false, PrefUtils.validateFlightNumber(invalidFlightNuber))
    }

    @Test
    fun checkDateNotSelected() {
        assertEquals(true, PrefUtils.validateDateText(invalidDateString))
    }

    @Test
    fun checkFromDateNotSelected() {
        assertEquals(true, PrefUtils.validateFromToDate(invalidFromDateString))
    }

    @Test
    fun checkToDateNotSelected() {
        assertEquals(true, PrefUtils.validateFromToDate(invalidEndDateString))
    }

    @Test
    fun checkDateIsSelected() {
        assertEquals(false, PrefUtils.validateFromToDate(validDate))
    }

}
