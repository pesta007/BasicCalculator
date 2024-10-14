package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.CalculatorViewModel
import com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.components.CalculatorButton
import com.pesta.basiccalculator.ui.theme.BasicCalculatorTheme
import com.pesta.basiccalculator.ui.theme.Blue
import com.pesta.basiccalculator.ui.theme.Orange
import com.pesta.basiccalculator.ui.theme.Pink

@Composable
fun CalculatorBodySection(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier,
    verticalSpacing: Dp = 10.dp,
    horizontalSpacing: Dp = 10.dp,
) {
    val onButtonClicked: (String) -> Unit = {viewModel.append(it)}

    Column(
        verticalArrangement = Arrangement.spacedBy(verticalSpacing),
        modifier = modifier
    ) {
        val buttonModifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
        Row(
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
        ) {
            CalculatorButton(
                label = "AC",
                color = Pink,
                onClick = {viewModel.clearExpression()},
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "^",
                color = Pink,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "%",
                color = Pink,
                onClick = onButtonClicked,
                modifier = buttonModifier,
            )
            CalculatorButton(
                label = "/",
                color = Pink,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
        ) {
            CalculatorButton(
                label = "7",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "8",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "9",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "x",
                color = Pink,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
        ) {
            CalculatorButton(
                label = "4",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "5",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "6",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "-",
                color = Pink,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
        ) {
            CalculatorButton(
                label = "1",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "2",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "3",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "+",
                color = Pink,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
        ) {
            CalculatorButton(
                label = "0",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = ".",
                color = Blue,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "DEL",
                color = Blue,
                onClick = {viewModel.deleteSingleEntry()},
                modifier = buttonModifier
            )
            CalculatorButton(
                label = "=",
                color = Orange,
                onClick = onButtonClicked,
                modifier = buttonModifier
            )
        }
    }
}

@Preview
@Composable
private fun CalculatorBodySectionPreview() {
    BasicCalculatorTheme {
        CalculatorBodySection(
            modifier = Modifier.fillMaxWidth(),
            horizontalSpacing = 0.dp,
            verticalSpacing = 0.dp
        ) { }
    }
}