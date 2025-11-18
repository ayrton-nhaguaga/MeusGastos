package com.ayrtonnhaguaga.meusgastos.dto.request

import com.ayrtonnhaguaga.meusgastos.model.ExpenseCategory
import com.ayrtonnhaguaga.meusgastos.model.PaymentMethod
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import java.math.BigDecimal
import java.time.LocalDate

data class ExpenseUpdateRequest(
    @field:NotBlank(message = "Descrição é obrigatória")
    val description: String,

    @field:NotNull(message = "Valor é obrigatório")
    @field:DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    val amount: BigDecimal,

    @field:NotNull(message = "Categoria é obrigatória")
    val category: ExpenseCategory,

    @field:NotNull(message = "Data é obrigatória")
    @field:PastOrPresent(message = "Data não pode ser futura")
    val expenseDate: LocalDate,

    @field:NotNull(message = "Método de pagamento é obrigatório")
    val paymentMethod: PaymentMethod,

    val notes: String? = null
)