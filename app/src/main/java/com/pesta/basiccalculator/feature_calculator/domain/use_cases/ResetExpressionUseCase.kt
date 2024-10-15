package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import javax.inject.Inject

class ResetExpressionUseCase @Inject constructor(private val repository: ExpressionRepository) {
    suspend operator fun invoke(){
        repository.reset()
    }
}