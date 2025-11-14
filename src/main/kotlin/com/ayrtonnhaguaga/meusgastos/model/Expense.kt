package com.ayrtonnhaguaga.meusgastos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "expenses")
data class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotBlank(message = "Descrição é obrigatória")
    @Column(nullable = false, length = 500)
    val description: String,

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    @Column(nullable = false, precision = 10, scale = 2)
    val amount: BigDecimal,

    @NotNull(message = "Categoria é obrigatória")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    val category: ExpenseCategory,

    @NotNull(message = "Data da despesa é obrigatória")
    @Column(nullable = false, name = "expense_date")
    val expenseDate: LocalDate,

    @NotNull(message = "Método de pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, name = "payment_method")
    val paymentMethod: PaymentMethod,

    @Column(length = 1000)
    val notes: String? = null,

)
{
    @PreUpdate
    fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
