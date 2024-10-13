package com.pesta.calculator

import org.junit.Assert.assertEquals
import org.junit.Test


class CalculatorTest {
    @Test
    fun simpleCalculation(){
        val expected = 5.0
        val actual = calculate("2+3")
        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun longCalculation(){
        val expected = -382.0
        val actual = calculate("2 + 4 / 2 * 2^5 * (2 - 8)")
        assertEquals(expected, actual, 0.0)
    }

    @Test
    fun complexCalculation(){
        val expected = -511.47
        val actual = calculate("2.1 * 67%42 -7*82/12*(23-12)")
        assertEquals(expected, actual, 0.01)
    }
}