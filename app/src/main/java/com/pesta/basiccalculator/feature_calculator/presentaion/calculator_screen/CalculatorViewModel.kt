package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.AppendToExpressionUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.GetExpressionUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.ResetExpressionUseCase
import com.pesta.basiccalculator.feature_calculator.domain.use_cases.UndoLastEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val appendToExpression: AppendToExpressionUseCase,
    getExpression: GetExpressionUseCase,
    private val undoLastEntry: UndoLastEntryUseCase,
    private val reset: ResetExpressionUseCase
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