package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetExpressionUseCase @Inject constructor(
    private val repository: ExpressionRepository
) {
    operator fun invoke() = repository.expression
}