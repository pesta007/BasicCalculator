package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.AppendToExpressionUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.GetExpressionUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.RestExpressionUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.UndoLastEntryUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.UpdateExpressionUseCase
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val appendToExpression: AppendToExpressionUseCase,
    getExpression: GetExpressionUseCase,
    private val undoLastEntry: UndoLastEntryUseCase,
    private val reset: RestExpressionUseCase
): ViewModel() {
    val expressionFlow = getExpression()

    fun append(value: String){
        viewModelScope.launch {
            appendToExpression(value.first())
        }
    }

    fun deleteSingleEntry(){
        viewModelScope.launch {
            undoLastEntry()
        }
    }

    fun clearExpression(){
        viewModelScope.launch {
            reset()
        }
    }
}