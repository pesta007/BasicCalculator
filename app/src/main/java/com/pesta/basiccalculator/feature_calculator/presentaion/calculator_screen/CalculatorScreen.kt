package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pesta.basiccalculator.ui.theme.BasicCalculatorTheme

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier
){
    Column(modifier) {
        CalculatorDisplaySection(
            content = "312",
            modifier = Modifier.fillMaxWidth()
        )
        CalculatorBodySection(
            verticalSpacing = 0.dp,
            horizontalSpacing = 0.dp,
            modifier = Modifier.fillMaxWidth()
        ) {  }
    }
}

@Preview
@Composable
private fun CalculatorScreenPreview() {
    BasicCalculatorTheme {
        Box(modifier = Modifier.fillMaxSize()){
            CalculatorScreen(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}