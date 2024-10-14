package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import com.pesta.basiccalculator.feature_calculator.domain.repository.FakeExpressionRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UpdateExpressionUseCaseTest {
    private lateinit var repository: ExpressionRepository
    private lateinit var updateExpression: UpdateExpressionUseCase

    @Before
    fun setUp(){
        repository = FakeExpressionRepository()
        updateExpression = UpdateExpressionUseCase(repository)
    }

    @Test
    fun updateExpressionRegularTest() = runBlocking{
        val expected = "2+12+73*43"
        updateExpression(expected)
        val actual = repository.expression.first()
        assertEquals(expected, actual)
    }

    @Test
    fun updateExpressionRefactoringTest() = runBlocking{
        val expected = "2+12+73*0.43"
        updateExpression("2+12+073*.43")
        val actual = repository.expression.first()
        assertEquals(expected, actual)
    }
}