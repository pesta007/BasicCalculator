package com.pesta.basiccalculator.feature_calculator.domain.use_cases

import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository

class UpdateExpressionUseCase(private val repository: ExpressionRepository) {
    suspend operator fun invoke(newExpression:String){
        Regex("[0-9 .]+").replace(newExpression){result ->
            val doubleValue = result.value.toDouble()
            val intValue = result.value.toIntOrNull()
            if (doubleValue == intValue?.toDouble())
                intValue.toString()
            else
                doubleValue.toString()
        }.apply {
            repository.updateExpression(this)
        }
    }
}