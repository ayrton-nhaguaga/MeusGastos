package com.ayrtonnhaguaga.meusgastos.dto.response

import com.ayrtonnhaguaga.meusgastos.model.ExpenseCategory
import java.math.BigDecimal

data class CategorySummary(
    val category: ExpenseCategory,
    val total: BigDecimal,
    val percentage: Double,
    val count: Int
)