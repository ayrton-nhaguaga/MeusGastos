// src/main/kotlin/com/ayrtonnhaguaga/meusgastos/dto/response/DashboardResponse.kt
package com.ayrtonnhaguaga.meusgastos.dto.response

import com.ayrtonnhaguaga.meusgastos.model.ExpenseCategory
import java.math.BigDecimal

data class DashboardResponse(
    val totalCurrentMonth: BigDecimal,
    val totalPreviousMonth: BigDecimal,
    val monthlyComparison: MonthlyComparison,
    val categorySummary: List<CategorySummary>,
    val recentExpenses: List<ExpenseResponse>
)
