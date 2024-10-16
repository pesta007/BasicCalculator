package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UndoLastEntryUseCase @Inject constructor(
    private val getExpression: GetExpressionUseCase,
    private val updateExpression: UpdateExpressionUseCase
) {
    suspend operator fun invoke(){
        val expression = getExpression().first()
        updateExpression(expression.dropLast(1))
    }
}