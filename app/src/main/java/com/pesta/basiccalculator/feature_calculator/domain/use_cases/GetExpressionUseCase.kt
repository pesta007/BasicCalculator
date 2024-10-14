package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import kotlinx.coroutines.flow.flow

class GetExpressionUseCase(
    private val repository: ExpressionRepository
) {
    operator fun invoke() = repository.expression
}