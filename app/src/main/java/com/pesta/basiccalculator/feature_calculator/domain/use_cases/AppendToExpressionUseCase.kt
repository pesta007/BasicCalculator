package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last

class AppendToExpressionUseCase(
    private val getExpression: GetExpressionUseCase,
    private val updateExpression: UpdateExpressionUseCase
) {
    suspend operator fun invoke(value: Char){
        if (value == '.')
            appendDecPoint()
        else if (value.isDigit())
            appendDigit(value.digitToInt())
        else
            appendOperation(value)
    }

    private suspend fun appendDigit(digit: Int){
        val expression = getExpression().first()
        updateExpression(expression + digit)
    }

    private suspend fun appendOperation(operation: Char){
        val expression = getExpression().first()
        if (expression.last().isDigit())
            updateExpression(expression + operation)
        else
            updateExpression(expression.replace(Regex(".$"), operation.toString()))
    }

    private suspend fun appendDecPoint(){
        val expression = getExpression().first()
        val lastNumeral = Regex("[1-9 .]*\$").find(expression)?.value

        if (lastNumeral == null){
            updateExpression(expression + "0.")
            return
        }

        if (!lastNumeral.contains("."))
            updateExpression("$expression.")
    }
}