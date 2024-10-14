package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import com.pesta.basiccalculator.feature_calculator.domain.repository.FakeExpressionRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UndoLastEntryUseCaseTest {

    private lateinit var repository: ExpressionRepository
    private lateinit var updateExpression: UpdateExpressionUseCase
    private lateinit var getExpression: GetExpressionUseCase
    private lateinit var undoLastEntry: UndoLastEntryUseCase

    @Before
    fun setUp(){
        repository = FakeExpressionRepository()
        updateExpression = UpdateExpressionUseCase(repository)
        getExpression = GetExpressionUseCase(repository)
        undoLastEntry = UndoLastEntryUseCase(
            getExpression, updateExpression
        )
    }

    @Test
    fun `remove last digit`() = runBlocking{
        val expected = "12*26/1"
        repository.updateExpression(expected+2)
        undoLastEntry()
        val actual = repository.expression.first()
        assertEquals(expected, actual)
    }

    @Test
    fun `remove last dot`() = runBlocking{
        val expected = "12*26/1"
        repository.updateExpression("$expected.")
        undoLastEntry()
        val actual = repository.expression.first()
        assertEquals(expected, actual)
    }

    @Test
    fun `remove last sign`() = runBlocking{
        val expected = "12*26/1"
        repository.updateExpression("$expected+")
        undoLastEntry()
        val actual = repository.expression.first()
        assertEquals(expected, actual)
    }
}