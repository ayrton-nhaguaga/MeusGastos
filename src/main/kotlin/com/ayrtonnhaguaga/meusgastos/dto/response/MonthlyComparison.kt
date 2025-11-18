package com.ayrtonnhaguaga.meusgastos.dto.response

import java.math.BigDecimal

data class MonthlyComparison(
    val difference: BigDecimal,
    val percentage: Double,
    val isIncrease: Boolean
)