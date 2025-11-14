package com.ayrtonnhaguaga.meusgastos.model

import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "expenses")
data class Expense(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,


    @Column(nullable = false, length = 500)
    val description: String,


    @Column(nullable = false, precision = 10, scale = 2)
    val amount: BigDecimal,


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    val category: ExpenseCategory,


    @Column(nullable = false, name = "expense_date")
    val expenseDate: LocalDate,


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20, name = "payment_method")
    val paymentMethod: PaymentMethod,

    @Column(length = 1000)
    val notes: String? = null,

    @Column(nullable = false, updatable = false, name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false, name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()

) {
    @PreUpdate
    fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}