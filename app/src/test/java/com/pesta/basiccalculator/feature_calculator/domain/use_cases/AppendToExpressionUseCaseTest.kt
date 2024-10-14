package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import com.pesta.basiccalculator.feature_calculator.domain.repository.FakeExpressionRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppendToExpressionUseCaseTest {
    private lateinit var repository: ExpressionRepository
    private lateinit var updateExpression: UpdateExpressionUseCase
    private lateinit var getExpression: GetExpressionUseCase
    private lateinit var appendToExpression: AppendToExpressionUseCase

    @Before
    fun setUp(){
        repository = FakeExpressionRepository()
        updateExpression = UpdateExpressionUseCase(repository)
        getExpression = GetExpressionUseCase(repository)
        appendToExpression = AppendToExpressionUseCase(
            getExpression, updateExpression
        )
    }

    @Test
    fun `append a digit to the default value 0`() = runBlocking{
        val expected = "1"
        appendToExpression('1')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun `append a digit to expression ending with a digit`() = runBlocking{
        val expected = "12+4+43.21"
        updateExpression("12+4+43.2")
        appendToExpression('1')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun `append a digit to expression ending with a dot`() = runBlocking{
        val expected = "12+4+43.1"
        updateExpression("12+4+43.")
        appendToExpression('1')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun `append a digit to expression ending with a sign`() = runBlocking{
        val expected = "12+4+43.1+1"
        updateExpression("12+4+43.1+")
        appendToExpression('1')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun `append a sign to expression ending with a digit`() = runBlocking{
        val expected = "12+4+43.1+"
        updateExpression("12+4+43.1")
        appendToExpression('+')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun `append a sign to expression ending with a dot`() = runBlocking{
        val expected = "12+4+43+"
        updateExpression("12+4+43.")
        appendToExpression('+')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }
    @Test
    fun `append a sign to expression ending with a sign`() = runBlocking{
        val expected = "12+4+43.1-"
        updateExpression("12+4+43.1+")
        appendToExpression('-')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }
    @Test
    fun `append a dot to expression ending with a digit`() = runBlocking{
        val expected = "12+4+43."
        updateExpression("12+4+43")
        appendToExpression('.')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun `append a dot to expression ending with a dot`() = runBlocking{
        val expected = "12+4+43."
        updateExpression("12+4+43.")
        appendToExpression('.')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }
    @Test
    fun `append a dot to expression ending with a sign`() = runBlocking{
        val expected = "12+4+43+."
        updateExpression("12+4+43+")
        appendToExpression('.')
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }
}