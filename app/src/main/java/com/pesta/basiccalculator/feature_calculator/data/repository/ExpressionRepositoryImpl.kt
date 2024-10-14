package com.pesta.basiccalculator.feature_calculator.data.repository

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ExpressionRepositoryImpl: ExpressionRepository {

    private val _expression = MutableStateFlow("0")

    override val expression: StateFlow<String>
        get() = _expression

    override suspend fun updateExpression(newExpression: String) {
        _expression.emit(newExpression)
    }

    override suspend fun reset() {
        _expression.emit("0")
    }
}