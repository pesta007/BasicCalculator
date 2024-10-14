package com.pesta.basiccalculator.feature_calculator.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

class FakeExpressionRepository: ExpressionRepository {

    private val _expression: MutableStateFlow<String> = MutableStateFlow("0")
    override val expression = _expression.asStateFlow()

    override suspend fun updateExpression(newExpression: String) {
        _expression.emit(newExpression)
    }

    override suspend fun reset() {
        _expression.emit("0")
    }
}