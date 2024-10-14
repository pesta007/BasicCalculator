package com.pesta.basiccalculator.feature_calculator.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ExpressionRepository {
    val expression: StateFlow<String>
    suspend fun updateExpression(newExpression: String)
    suspend fun reset()
}