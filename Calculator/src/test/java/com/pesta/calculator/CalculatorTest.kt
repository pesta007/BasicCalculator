package com.pesta.calculator

import org.junit.Assert.assertEquals
import org.junit.Test


class CalculatorTest {
    @Test
    fun calculateTest(){
        val expected = 5L
        val actual = calculate("2+3")
        assertEquals(expected, actual)
    }
}