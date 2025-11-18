package com.ayrtonnhaguaga.meusgastos.dto.response

import com.ayrtonnhaguaga.meusgastos.model.ExpenseCategory
import com.ayrtonnhaguaga.meusgastos.model.PaymentMethod
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class ExpenseResponse(
    val id: Long,
    val description: String,
    val amount: BigDecimal,
    val category: ExpenseCategory,
    val expenseDate: LocalDate,
    val paymentMethod: PaymentMethod,
    val notes: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)