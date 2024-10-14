package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pesta.basiccalculator.ui.theme.BasicCalculatorTheme

@Composable
fun CalculatorDisplaySection(
    content: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 32.sp
) {
    Box(modifier) {
        Text(
            text = content,
            fontSize = textSize,
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
private fun CalculatorDisplaySectionPreview() {
    BasicCalculatorTheme {
        Surface(color = MaterialTheme.colorScheme.secondary) {
            CalculatorDisplaySection(
                content = "2+4",
                modifier = Modifier.fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}