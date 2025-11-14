package com.ayrtonnhaguaga.meusgastos.model


import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.YearMonth

@Entity
@Table(
    name = "budgets",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["category", "year_month"])
    ]
)
data class Budget(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    val category: ExpenseCategory,

    @NotNull
    @DecimalMin(value = "0.01", message = "Valor do orçamento deve ser maior que zero")
    @Column(nullable = false, precision = 10, scale = 2)
    val amount: BigDecimal,

    @NotNull
    @Column(nullable = false, name = "year_month")
    val yearMonth: YearMonth, // Ex: 2024-01

    @Column(length = 500)
    val description: String? = null
)