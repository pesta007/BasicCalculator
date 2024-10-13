package com.pesta.calculator

import net.objecthunter.exp4j.ExpressionBuilder


/**
 * Calculates the provided formula and returns the result as a long
 * @param formula the formula used to calculate ex: 3+2*(3-1)^3/2
 * symbols:
 * + -> plus
 * - -> minus
 * * -> times
 * / -> divided by
 * ^ -> to the power of
 */
fun calculate(formula: String): Double{
    return ExpressionBuilder(formula).build().evaluate()
}
