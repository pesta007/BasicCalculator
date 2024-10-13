package com.pesta.basiccalculator.feature_calculator.presentaion.calculator_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pesta.basiccalculator.ui.theme.BasicCalculatorTheme
import com.pesta.basiccalculator.ui.theme.Pink

@Composable
fun CalculatorButton(
    label: String,
    color: Color,
    textSize: TextUnit = 24.sp,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.background(color),
    ){
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(0.8f)
                .background(color)
                .clip(RoundedCornerShape(4.dp))
                .shadow(elevation = 2.dp, ambientColor = Color.White)
        ){
            Text(text = label, modifier = Modifier.align(Alignment.Center), fontSize = textSize)
        }
    }
}

@Preview
@Composable
private fun CalculatorButtonPreview() {
    BasicCalculatorTheme {
        CalculatorButton(
            label = "1",
            color = Pink,
            modifier = Modifier.size(100.dp)
        )
    }
}