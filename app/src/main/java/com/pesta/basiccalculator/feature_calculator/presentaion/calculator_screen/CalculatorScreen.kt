package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.sections.CalculatorBodySection
import com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.sections.CalculatorDisplaySection
import com.pesta.basiccalculator.ui.theme.BasicCalculatorTheme

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
){
    Column(modifier) {
        CalculatorDisplaySection(
            content = viewModel.expressionFlow.collectAsState().value,
            modifier = Modifier.fillMaxWidth()
        )
        CalculatorBodySection(
            verticalSpacing = 0.dp,
            horizontalSpacing = 0.dp,
            modifier = Modifier.fillMaxWidth(),
            viewModel = viewModel
        )
    }
}

@Preview
@Composable
private fun CalculatorScreenPreview() {
    BasicCalculatorTheme {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)){
            CalculatorScreen(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}