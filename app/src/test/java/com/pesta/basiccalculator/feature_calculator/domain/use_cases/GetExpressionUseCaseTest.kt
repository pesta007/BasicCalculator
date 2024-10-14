package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import com.pesta.basiccalculator.feature_calculator.domain.repository.FakeExpressionRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetExpressionUseCaseTest{
    private lateinit var repository: ExpressionRepository
    private lateinit var getExpression: GetExpressionUseCase

    @Before
    fun setUp(){
        repository = FakeExpressionRepository()
        getExpression = GetExpressionUseCase(repository)
    }

    @Test
    fun getExpressionDefaultValueTest() = runBlocking{
        val expected = "0"
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }

    @Test
    fun getExpressionTest() = runBlocking{
        val expected = "1+23*76/23-1"
        repository.updateExpression(expected)
        val actual = getExpression().first()
        assertEquals(expected, actual)
    }
}